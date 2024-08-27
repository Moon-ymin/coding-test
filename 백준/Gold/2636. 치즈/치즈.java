
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][], cheeze, deletecheeze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        cheeze = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0){
                    map[i][j] = num;
                } else {
                    map[i][j] = 2;
                    cheeze += 1;
                }
            }
        }
        int time = 0;
        while(cheeze > 0){
            visited = new boolean[R][C];
            bfs(0, 0); // 공기랑 닿는 부분 탐색하기
            delete();
            cheeze -= deletecheeze;
            time++;
        }
        System.out.println(time);
        System.out.println(deletecheeze);

    }
    private static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir], ny = cy + dy[dir];

                if(nx < 0 || ny <0 || nx>= map.length || ny>= map[0].length || visited[nx][ny]) continue;

                // 외부 공기랑 닿는 곳 찾기
                if(map[nx][ny] == 0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else if(map[nx][ny] == 2) {
                    // 외부 공기 닿는 2인 곳에 1로 바꿔서 구멍 뚫린거 표시
                    map[nx][ny] = 1;
                    visited[nx][ny] = true;
                }

            }
        }
    }
    private static void delete() {
        deletecheeze = 0;
        // 1이라서 구멍생긴 곳 치즈 없애기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    deletecheeze++;
                }
            }
        }
    }
}
