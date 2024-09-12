import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T, map[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        move();
    }

    private static void move() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0}); // x, y, 그람 수 (0: 그람 없음, 1: 그람 있음)
        boolean[][][] isVisited = new boolean[N][M][2]; // 2차원 배열, 그람 보유 여부 0/1로 나누어 방문 체크
        isVisited[0][0][0] = true;
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            // 시간이 초과한 경우
            if (time > T) {
                System.out.println("Fail");
                return;
            }
            
            while(size-- > 0) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int gram = cur[2]; // 0이면 그람 없음, 1이면 그람 있음
                
                // 공주님 위치에 도착한 경우
                if (x == N-1 && y == M-1) {
                    System.out.println(time);
                    return;
                }
                
                for(int dir=0; dir<4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    
                    // 맵 범위 밖으로 나가는 경우
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    
                    // 그람을 가진 경우
                    if (gram == 1) {
                        if (!isVisited[nx][ny][1]) { // 그람이 있을 때 방문 안 했으면
                            q.offer(new int[] {nx, ny, 1});
                            isVisited[nx][ny][1] = true;
                        }
                    } 
                    // 그람이 없는 경우
                    else {
                        if (map[nx][ny] != 1 && !isVisited[nx][ny][0]) { // 벽이 아니고 방문 안 했으면
                            q.offer(new int[] {nx, ny, map[nx][ny] == 2 ? 1 : 0}); // 그람 얻으면 gram=1
                            isVisited[nx][ny][0] = true;
                        }
                    }
                }
            }
            time++;
        }
        System.out.println("Fail");
    }
}