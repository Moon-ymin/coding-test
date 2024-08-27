import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static String[][] map;
    static boolean[][] isVisited;
    static Set<Character> chars;
    static int R, C, max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new String[R][C];
        chars = new HashSet<>();

        for (int r = 0; r < R; r++) {
            String str = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = "" + str.charAt(c);
            }
        }
        
        max = 0;
        chars.add(map[0][0].charAt(0));
        isVisited = new boolean[R][C];
        isVisited[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth) {
        max = Math.max(max, depth);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            char nextChar = map[nx][ny].charAt(0);
            if (isVisited[nx][ny] || chars.contains(nextChar)) continue;

            isVisited[nx][ny] = true;
            chars.add(nextChar);
            dfs(nx, ny, depth + 1);
            chars.remove(nextChar);
            isVisited[nx][ny] = false;
        }
    }
}