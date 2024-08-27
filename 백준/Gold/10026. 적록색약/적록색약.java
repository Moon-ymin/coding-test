import java.util.Scanner;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        int no = countRegions(false);
        int yes = countRegions(true);

        System.out.println(no + " " + yes);
    }

    private static int countRegions(boolean isyes) {
        int count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j], isyes);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, char color, boolean isyes) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            char nc = map[nx][ny];

            if (isyes) {
                if ((color == 'R' || color == 'G') && (nc == 'B')) continue;
                if ((color == 'B') && (nc != 'B')) continue;
            } else {
                if (color != nc) continue;
            }

            dfs(nx, ny, nc, isyes);
        }
    }
}