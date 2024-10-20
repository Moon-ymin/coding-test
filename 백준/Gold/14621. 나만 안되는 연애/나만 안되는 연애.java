import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 학교 입력 받음
    // 남학교, 여학교 집합 다를때만 연결하기 MST
    static class Edge implements Comparable<Edge> {
        int start, end, value;
        Edge(int start, int end, int value) {
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
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) parents[i] = i;
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
    static int N, M, parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] schools = new String[N+1];
        for (int i = 1; i <= N; i++) {
            schools[i] = st.nextToken();
        }
        make();
        Edge[] edges = new Edge[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, value);
        }
        Arrays.sort(edges);

        int cnt=0, total=0;
        for(Edge e: edges){
            if (schools[e.start].equals(schools[e.end])) continue;
            if (union(e.start, e.end)) {
                total += e.value;
                if (++cnt == N-1) break;
            }
        }

        // 모든 학교를 연결할 수 없는 경우 -1
        if (cnt != N-1) System.out.println(-1);
        else System.out.println(total);

    }
}