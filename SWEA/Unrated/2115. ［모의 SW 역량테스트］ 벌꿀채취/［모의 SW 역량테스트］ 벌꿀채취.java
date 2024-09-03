import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int map[][], N, M, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 행의 크기
            M = Integer.parseInt(st.nextToken()); // 열의 크기
            C = Integer.parseInt(st.nextToken()); // 최대 꿀 채취량

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가능한 채취 구성 찾기
            sb.append("#").append(t).append(" ").append(find()).append("\n");
        }
        System.out.println(sb);
    }

    private static int find() {
        int total = 0;
        for (int i = 0; i < N; i++) {
            // 행에서 첫 번째 사람이 채집할 수 있는 인덱스 범위
            for (int j = 0; j <= N - M; j++) { // M - M
                int first = getMax(i, j);
                // 첫 번째 사람 선택 이후에 두 번째 사람 선택
                for (int r = i; r < N; r++) {
                    for (int c = (r == i ? j + M : 0); c <= N - M; c++) { // M - M
                        int second = getMax(r, c);
                        total = Math.max(total, first + second);
                    }
                }
            }
        }
        return total;
    }

    private static int getMax(int r, int c) {
        int[] honey = new int[M];
        for (int i = 0; i < M; i++) {
            honey[i] = map[r][c + i];
        } // 통 하나에 해당하는 길이 M만큼의 꿀
        return getTotal(honey, 0, 0, 0);
    }

    private static int getTotal(int[] honey, int idx, int sum, int honeys) {
        if (sum > C) return 0;

        if (idx == honey.length) return honeys;

        int include = getTotal(honey, idx + 1, sum + honey[idx], honeys + honey[idx] * honey[idx]);
        int exclude = getTotal(honey, idx + 1, sum, honeys);

        return Math.max(include, exclude);
    }
}