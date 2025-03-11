import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M, K;
    static int[][] map, originalMap;
    static int[][] rotations;
    static boolean[] visited;
    static int[] order;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        originalMap = new int[N + 1][M + 1];
        rotations = new int[K][3];
        visited = new boolean[K];
        order = new int[K];

        // 원본 배열 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 연산 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotations[i][0] = Integer.parseInt(st.nextToken()); // r
            rotations[i][1] = Integer.parseInt(st.nextToken()); // c
            rotations[i][2] = Integer.parseInt(st.nextToken()); // s
        }

        // 순열을 이용한 회전 순서 탐색
        permute(0);

        // 최솟값 출력
        System.out.println(minResult);
    }

    // 순열 생성 (회전 연산의 순서를 고려)
    static void permute(int depth) {
        if (depth == K) {
            // 원본 배열 복사 후 회전 실행
            copyOriginal();
            for (int i = 0; i < K; i++) {
                int idx = order[i];
                int r = rotations[idx][0];
                int c = rotations[idx][1];
                int s = rotations[idx][2];

                int leftR = r - s;
                int leftC = c - s;
                int rightR = r + s;
                int rightC = c + s;

                // 회전 연산 시작
                while (true) {
                    if (!canRotate(leftR, leftC, rightR, rightC)) break;
                    rotate(leftR, leftC, rightR, rightC);
                    leftR++;
                    leftC++;
                    rightR--;
                    rightC--;
                }
            }
            minResult = Math.min(minResult, calculateMinRowSum());
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }

    // 원본 배열 복사
    static void copyOriginal() {
        for (int i = 1; i <= N; i++) {
            System.arraycopy(originalMap[i], 1, map[i], 1, M);
        }
    }

    // 배열 A의 값 구하기 - 행의 합 중 최소값
    private static int calculateMinRowSum() {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += map[i][j];
            }
            result = Math.min(result, sum);
        }
        return result;
    }

    // 기존 메서드 유지
    private static boolean canRotate(int leftR, int leftC, int rightR, int rightC) {
        return (leftR != rightR && leftC != rightC && leftR < rightR && leftC < rightC);
    }

    private static void rotate(int leftR, int leftC, int rightR, int rightC) {
        int garo = rightC - leftC;
        int sero = rightR - leftR;

        int before = map[leftR][leftC];
        int after;
        for (int i = 1; i <= garo; i++) {
            after = map[leftR][leftC + i];
            map[leftR][leftC + i] = before;
            before = after;
        }
        for (int i = 1; i <= sero; i++) {
            after = map[leftR + i][rightC];
            map[leftR + i][rightC] = before;
            before = after;
        }
        for (int i = 1; i <= garo; i++) {
            after = map[rightR][rightC - i];
            map[rightR][rightC - i] = before;
            before = after;
        }
        for (int i = 1; i <= sero; i++) {
            after = map[rightR - i][leftC];
            map[rightR - i][leftC] = before;
            before = after;
        }
    }
}
