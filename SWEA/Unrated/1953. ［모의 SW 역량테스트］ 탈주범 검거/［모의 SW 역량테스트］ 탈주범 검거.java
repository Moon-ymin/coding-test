import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, R, C, L, map[][], result;
    static boolean[][] isVisited;

    // 방향 설정 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 파이프 종류별로 연결 가능한 방향들 (상, 하, 좌, 우)
    static int[][] pipeDir = {
            {},
            {0, 1, 2, 3},  // 1번 파이프
            {0, 1},        // 2번 파이프
            {2, 3},        // 3번 파이프
            {0, 3},        // 4번 파이프
            {1, 3},        // 5번 파이프
            {1, 2},        // 6번 파이프
            {0, 2}         // 7번 파이프
    };

    static class Pipe {
        int x, y;

        public Pipe(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            isVisited = new boolean[N][M];
            result = 1; // 시작 위치도 방문 처리
            bfs(R, C);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int R, int C) {
        Queue<Pipe> q = new ArrayDeque<>();
        q.offer(new Pipe(R, C));
        isVisited[R][C] = true;
        int time = 1;

        while (!q.isEmpty() && time < L) {
            int size = q.size();

            while (size-- > 0) {
                Pipe curPipe = q.poll();
                int x = curPipe.x;
                int y = curPipe.y;
                int curPipeType = map[x][y];

                for (int dir : pipeDir[curPipeType]) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] == 0 || isVisited[nx][ny]) continue;

                    int nextPipeType = map[nx][ny];
                    // 다음 파이프가 현재 파이프와 연결될 수 있는지 확인
                    if (canGo(nx, ny, dir)) {
                        isVisited[nx][ny] = true;
                        q.offer(new Pipe(nx, ny));
                        result++;
                    }
                }
            }
            time++;
        }
    }

    private static boolean canGo(int x, int y, int dir) {
        int nextPipeType = map[x][y];
        // 현재 방향의 반대 방향으로 다음 파이프가 연결될 수 있는지 확인
        int reverseDir = (dir % 2 == 0) ? dir + 1 : dir - 1;
        for (int nextDir : pipeDir[nextPipeType]) {
            if (nextDir == reverseDir) {
                return true;
            }
        }
        return false;
    }
}