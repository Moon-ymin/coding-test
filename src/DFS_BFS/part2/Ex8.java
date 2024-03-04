package DFS_BFS.part2;

import java.util.Scanner;

public class Ex8 {
    // 음료수 얼려 먹기
    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y){
        // 범위 벗어나는지
        if ( x <= -1 || x >= n || y <= -1 || y >= m ) {
            return false;
        }
        // 0인지 확인
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x-1, 0); // 상하좌우
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        } return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
