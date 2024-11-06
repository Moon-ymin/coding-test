import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[][] board;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new boolean[N][M];

        // 백트래킹 시작
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int x, int y) {
        // 열을 넘어가면 다음 행으로 이동
        if (y == M) {
            x++;
            y = 0;
        }

        if (x == N) {
            result++;
            return;
        }
        dfs(x, y + 1);

        if (canPlaceTile(x, y)) {
            board[x][y] = true;
            dfs(x, y + 1);
            board[x][y] = false;
        }
    }

    static boolean canPlaceTile(int x, int y) {
        if (x > 0 && y > 0 && board[x - 1][y] && board[x][y - 1] && board[x - 1][y - 1]) {
            return false;
        }
        return true; 
    }
}