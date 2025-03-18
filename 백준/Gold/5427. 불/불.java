import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static char[][] map;
    static Queue<int[]> fire, position;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            st = new StringTokenizer(br.readLine());
            fire = new ArrayDeque<>(); // 불이 난 곳
            position = new ArrayDeque<>(); // 상근이 위치

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            for(int i=0; i<h; i++){
                String line = br.readLine();
                for (int j=0; j<w; j++){
                    char c = line.charAt(j);
                    if (c == '@') position.add(new int[]{i, j});
                    else if (c == '*') fire.add(new int[]{i, j});
                    map[i][j] = c;
                }
            }

            int result = bfs();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    private static int bfs() {
        int time = 0;

        while(!position.isEmpty()){
            // 불 사방으로 확산
            int fireSize = fire.size();
            for (int i=0; i<fireSize; i++){
                int[] curFire = fire.poll();
                int x = curFire[0], y = curFire[1];

                for(int dir=0; dir<4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny] != '.' ) continue;
                    map[nx][ny] = '*';
                    fire.add(new int[]{nx, ny});
                }
            }

            // 상근이 이동
            int pSize = position.size();
            for (int i=0; i<pSize; i++){
                int[] curPos = position.poll();
                int x = curPos[0], y = curPos[1];

                for(int dir=0; dir<4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx<0 || nx>=h || ny<0 || ny>=w) return time+1; // 탈출함!
                    if (map[nx][ny] != '.') continue;
                    map[nx][ny] = '@';
                    position.add(new int[] {nx, ny});
                }
            }

            time++;
        }
        return -1;
    }

}
