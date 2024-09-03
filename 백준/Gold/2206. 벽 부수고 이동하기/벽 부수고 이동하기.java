import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][], min;
    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            char[] nums = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                map[r][c] = nums[c] - '0';
            }
        }

        // 벽 부수면서 이동하기
        min = Integer.MAX_VALUE;
        if (N == 1 && M == 1) {
            min = 1;
        } else {
            move();
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void move() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, 0, 1 }); // 좌표 x, y, 벽 부순 횟수, 현재까지의 경로 길이
        boolean[][][] isVisited = new boolean[N][M][2];
        isVisited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int breaking = cur[2];
            int dist = cur[3];

            if (r == N - 1 && c == M - 1) {
                min = Math.min(min, dist);
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (map[nr][nc] == 1 && breaking == 0) {
                    if (!isVisited[nr][nc][1]) {
                        q.offer(new int[] { nr, nc, 1, dist + 1 });
                        isVisited[nr][nc][1] = true;
                    }
                } else if (map[nr][nc] == 0 && !isVisited[nr][nc][breaking]) {
                    q.offer(new int[] { nr, nc, breaking, dist + 1 });
                    isVisited[nr][nc][breaking] = true;
                }
            }
        }
    }
}