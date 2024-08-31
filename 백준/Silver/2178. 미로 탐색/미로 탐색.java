import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] isVisited;
    static int N, M, min;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        min = Integer.MAX_VALUE;
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        isVisited[x][y] = true;
        map[x][y] = 1; // 시작 지점에서 거리 1로 시작

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            // 목표 지점 도달했으면
            if (cx == N-1 && cy == M-1){
                return map[cx][cy];
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir], ny = cy + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny]==0 || isVisited[nx][ny]) continue;
                isVisited[nx][ny] = true;
                map[nx][ny] = map[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return -1;
    }
}