import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] isVisited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        isVisited[x][y] = true;
        map[x][y] = 1; // 시작 지점에서의 거리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 목표 지점에 도착
            if (cx == N - 1 && cy == M - 1) {
                return map[cx][cy];
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    map[nx][ny] = map[cx][cy] + 1; // 거리 누적
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return -1;
    }
}