import java.util.NavigableMap;
import java.util.Scanner;

public class Main{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir; // 북 0 동 1 남 2 서 3
    static void turnLeft() {
        dir -= 1;
        if (dir == -1) dir = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] visit = new int[n][m];

        int x = sc.nextInt();
        int y = sc.nextInt();
        dir = sc.nextInt();
        visit[x][y] = 1;
        int visit_cnt = 1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        while(true){
            turnLeft();
            int nextx = x + dx[dir];
            int nexty = y + dy[dir];

            if (map[nextx][nexty] == 0 && visit[nextx][nexty] == 0) {
                x = nextx;
                y = nexty;
                visit[x][y] = 1;
                visit_cnt++;
                cnt = 0;
                continue;
            } else {
                cnt += 1;
            }
            if (cnt == 4) {
                nextx = x - dx[dir];
                nexty = y - dy[dir];

                if (map[nextx][nexty] == 0){
                    x = nextx; y = nexty; cnt = 0;
                } else {
                    break;
                }
            }
        }
        System.out.println(visit_cnt);

    }
}