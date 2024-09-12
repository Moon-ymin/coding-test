import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][];
    static class Tomato {
        int x, y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        Queue<Tomato> q = new ArrayDeque<>();
        int unripeTomatoes = 0; // 익지 않은 토마토의 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Tomato(i, j));
                } else if (map[i][j] == 0) {
                    unripeTomatoes++; // 익지 않은 토마토 세기
                }
            }
        }

        if (unripeTomatoes == 0) {
            System.out.println(0); // 이미 모두 익은 상태
            return;
        }

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Tomato cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;

                    map[nx][ny] = 1;
                    q.offer(new Tomato(nx, ny));
                    unripeTomatoes--; // 익지 않은 토마토 개수 감소
                }
            }
            time++;
        }

        if (unripeTomatoes == 0) {
            System.out.println(time - 1); // 최종 시간 출력
        } else {
            System.out.println(-1); // 익지 않은 토마토가 남아 있으면 -1 출력
        }
    }
}