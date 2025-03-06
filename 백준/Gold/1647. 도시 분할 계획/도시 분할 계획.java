import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 프림 -> 정점 중심
    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }

    static int N, M;
    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }
        // 프림 알고리즘 실행
        System.out.println(prim());
    }

    public static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int mstCost = 0;
        int maxEdgeWeight = 0;
        int edgeCount = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.v;

            if (visited[node]) continue;

            visited[node] = true;
            mstCost += edge.w;
            maxEdgeWeight = Math.max(maxEdgeWeight, edge.w);
            edgeCount++;

            if (edgeCount == N) break;

            for (Edge next : graph.get(node)) {
                if (!visited[next.v]) {
                    pq.add(next);
                }
            }
        }
        // 가장 큰 간선을 빼서 두 개의 마을로 나누기
        return mstCost - maxEdgeWeight;
    }

}
