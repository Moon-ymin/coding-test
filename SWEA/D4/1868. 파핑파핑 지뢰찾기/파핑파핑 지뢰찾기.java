import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int arr[][], result, N;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N][N];
            result = 0;

            for (int r = 0; r < N; r++) {
                String s = sc.next();
                for (int c = 0; c < N; c++) {
                    if (s.charAt(c) == '.') arr[r][c] = -1; // 빈 칸
                    else arr[r][c] = -2; // 지뢰
                }
            }
            pushZero();
            System.out.println("#" + t + " " + result);
        }
        sc.close();
    }

    static void pushZero() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c] == -1 && isZero(r, c)) {
                    click(r, c);
                    result++;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (arr[r][c] == -1) {
                    result++; // 클릭되지 않은 빈 칸만 추가
                }
            }
        }
    }

    static void click(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        arr[r][c] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != -1) continue;

                arr[nr][nc] = 0;
                if (isZero(nr, nc)) q.add(new int[]{nr, nc});
            }
        }
    }

    static boolean isZero(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == -2) return false;
        }
        return true;
    }
}