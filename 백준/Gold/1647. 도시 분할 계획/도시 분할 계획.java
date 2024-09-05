import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 크루스칼 알고리즘 적용 (간선 비용 기준 오름차순)
 * 전체 간선 중 가장 큰 간선을 제거 -> 두 개의 마을로 나뉨
 * @author SSAFY
 *
 */
public class Main {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N, M;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, weight);
        }

        // 1. 크루스칼 알고리즘 적용을 위한 간선 정렬
        Arrays.sort(edges);

        // 2. 최소 신장 트리 구하기
        makeSet();
        int mstCost = 0;
        int maxEdgeWeight = 0;  // 가장 큰 간선의 가중치를 저장할 변수
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                mstCost += edge.weight;
                maxEdgeWeight = edge.weight;  // 현재 간선이 추가될 때 가장 큰 가중치 갱신
                edgeCount++;
                if (edgeCount == N - 1) break;  // N-1개의 간선을 선택하면 MST 완성
            }
        }

        // 3. 가장 큰 간선의 비용을 빼서 두 개의 마을로 나누기
        System.out.println(mstCost - maxEdgeWeight);
    }

    // Union-Find 함수들
    static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}