import java.util.Scanner;

public class Main{
    static int R, C, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1}; // 우상향, 오른쪽, 우하향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        // 각 행의 첫 번째 열에서 시작해서 DFS 탐색
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    private static boolean dfs(int x, int y) {
        visited[x][y] = true;

        // 마지막 열에 도착한 경우 빵집까지 연결된 거임
        if (y == C-1) return true;

        // 우상향, 오른쪽, 우하향 순서로 탐색
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] == '.') {
                if (dfs(nx, ny)) {
                    return true; // 하나의 성공적인 경로만 찾으면 되므로 true 반환
                }
            }
        }
        return false; // 지금 경로로 빵집에 도달 못하는 경우
    }
}