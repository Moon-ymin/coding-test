import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // MST : value에 간선 값 + 노드 값
    static class Edge implements Comparable<Edge> {
        int start, end, value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static void make() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) parents[i] = i; // 가상의 우물 노드까지 포함
    }

    static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }

    static int N, parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] water = new int[N + 1];

        // 각 논에서 우물을 파는 비용 (노드 비용)
        for (int i = 1; i <= N; i++) {
            water[i] = Integer.parseInt(br.readLine());
        }

        // 논들 간의 간선 정보 저장 (간선 비용)
        Edge[] edges = new Edge[N * (N - 1) / 2 + N];
        int idx = 0;

        // 논들 간의 연결 비용 추가
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i < j) {
                    edges[idx++] = new Edge(i, j, cost);
                }
            }
        }

        // 각 논에서 우물로 가는 비용을 가상의 노드(0번)와 연결하는 간선으로 추가
        for (int i = 1; i <= N; i++) {
            edges[idx++] = new Edge(0, i, water[i]); 
        }

        Arrays.sort(edges);
        make();

        int totalCost = 0, edgeCount = 0;

       
        for (Edge e : edges) {
            if (union(e.start, e.end)) {
                totalCost += e.value;
                edgeCount++;
                if (edgeCount == N) break;
            }
        }

        System.out.println(totalCost);
    }
}