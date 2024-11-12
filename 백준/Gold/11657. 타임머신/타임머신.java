import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M;
    static long[] dist;
    static List<Edge> edges;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 정점 수
        M = Integer.parseInt(st.nextToken());  // 간선 수

        dist = new long[N + 1];
        edges = new ArrayList<>();

        Arrays.fill(dist, INF);
        dist[1] = 0;  // 시작 정점 거리 0으로 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        // 벨만-포드 알고리즘 실행
        if (bellmanFord()) {
            System.out.println("-1");  // 음수 사이클 존재 시
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                sb.append(dist[i] == INF ? "-1" : dist[i]).append("\n");
            }
            System.out.print(sb);
        }
    }

    public static boolean bellmanFord() {
        for (int i = 1; i < N; i++) {  // (정점 - 1)번 반복
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }

        // 음수 사이클 체크
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                return true;  // 음수 사이클 존재
            }
        }

        return false;
    }
}