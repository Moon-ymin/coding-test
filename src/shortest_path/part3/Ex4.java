package shortest_path.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex4 {
    // 숨바꼭질
    static class Node implements Comparable<Node>{
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return distance;
        }

        // 거리 짧은게 우선순위 높게

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
    static final int INF = (int) 1e9;
    static int n, m;
    static int start = 1;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] d = new int[20001];
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정해서 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) {  // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance();  // 현재 노드까지의 비용
            int now = node.getIndex();  // 현재 노드
            // 현재 노드가 이미 처리된 적 있으면 다른 인접한 노드 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a번 노드와 b번 노드의 이동 비용이 1이라는 의미 (양방향)
            graph.get(a).add(new Node(b,1));
            graph.get(b).add(new Node(a,1));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 가장 최단 거리가 먼 노드 번호(동빈이가 숨을 헛간의 번호)
        int maxNode = 0;
        // 도달할 수 있는 노드 중에서, 가장 최단 거리가 먼 노드와의 최단 거리
        int maxDistance = 0;
        // 가장 최단 거리가 먼 노드와의 최단 거리와 동일한 최단 거리를 가지는 노드들의 리스트
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (maxDistance < d[i]) {
                maxNode = i;
                maxDistance = d[i];
                result.clear();
                result.add(maxNode);
            }
            else if (maxDistance == d[i]) {
                result.add(i);
            }
        }

        System.out.println(maxNode + " " + maxDistance + " " + result.size());



    }
}
