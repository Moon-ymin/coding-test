import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxHomes = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 마름모의 내부에 가장 큰 정사각형 크기는
                    // k=1, 2 -> 1
                    // k=3, 4 -> 3
                    // k=5, 6 -> 5 이다 k=N+1 까지 고려해야 함
                    for(int K=1; K<=N+1; K++){
                        // i, j 좌표에서 거리 K까지 커지는 마름모에서 내부에 속하는 집 개수
                        int houseCnt = bfs(new Node(i, j), K);
                        int cost = K * K + (K-1) * (K-1);
                        int profit = houseCnt*M - cost;
                        if (profit >= 0) maxHomes = Math.max(maxHomes, houseCnt);
                    }
                }
            }
            sb.append("#").append(t).append(" "+maxHomes+"\n");
        }
        System.out.println(sb);
    }
    private static int bfs(Node start, int K){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(start);
        visited[start.x][start.y] = true;
        int cnt = 0, distance = 0;

        while(!q.isEmpty() && distance < K){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node cur = q.poll();
                if (map[cur.x][cur.y] == 1) cnt++;
                for(int dir=0; dir<4; dir++){
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            distance++;
        }
        return cnt;
    }
}