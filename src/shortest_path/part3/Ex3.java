package shortest_path.part3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex3 {
    // 화성 탐사
    static class Node implements Comparable<Node> {

        private int x;
        private int y;
        private int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getDistance() {
            return this.distance;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    static final int INF = (int) 1e9;
    static int t, n;
    static int[][] graph = new int[125][125];
    static int[][] d = new int[125][125];
    // 상하좌우
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();

            // 정보 입력
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = sc.nextInt();
                }
            }
            // 최단 거리 테이블을 모두 무한으로 초기화
            for (int a = 0; a < n; a++) {
                Arrays.fill(d[a], INF);
            }

            int x=0, y=0;   // 시작 위치 0,0
            // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, graph[x][y]));
            d[x][y] = graph[x][y];

            while(!pq.isEmpty()) { // 다익스트라 알고리즘을 수행
                // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
                Node node = pq.poll();
                int dist = node.getDistance();
                x = node.getX();
                y = node.getY();
                // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
                if (d[x][y] < dist) continue;
                // 현재 노드와 연결된 다른 인접한 노드들을 확인
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    // 맵의 범위를 벗어나는 경우 무시
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    int cost = dist + graph[nx][ny];
                    // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                    if (cost < d[nx][ny]) {
                        d[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
            System.out.println(d[n - 1][n - 1]);
        }
    }
}
