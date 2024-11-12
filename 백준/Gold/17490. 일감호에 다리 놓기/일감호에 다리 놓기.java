import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이웃한 섬을 표시 | 이웃을 끊는 것이 중요 => parent로 모집합 체크로 구현
 * 처음 원형 연결은 : 이전 값을 참조하고, 1은 N을 참조하게 만듦
 * 
 * M=0 : 공사중인 곳 없는 경우, 사이클 존재 => 바로 YES
 * M=1 : 한 방향의 연결만 끊음, 사이클 존재 => 바로 YES
 * 
 * 끊는 것은 해당 점의 parent를 그 인덱스로 변경하는걸로 이웃점과 연결을 끊음
 * @author SSAFY
 *
 */

public class Main {
    public static class Edge implements Comparable<Edge> {
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

    static int[] parent;
    static int N, M;
    static long K;
    static Set<String> underConstructionSet = new HashSet<>(); // 공사 중인 간선 저장

    public static void make() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i-1;
        }
    }

    public static int findSet(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findSet(parent[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parent[aRoot] = bRoot;
        return true;
    }

    public static String generateEdgeKey(int a, int b) {
        return Math.min(a, b) + "," + Math.max(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        parent = new int[N + 1];
        make();
        parent[1] = N;

        List<Edge> edges = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	edges.add(new Edge(0, i, Integer.parseInt(st.nextToken())));
        }

        // 공사 중인 간선 입력 받기 - !!!! 이웃 끊기 !!!
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            
            if (min==1 && max == N){
            	parent[1] = 1;
            	continue;
            }
            parent[max] = max;
        }

        if (M <= 1) {
        	System.out.println("YES");
        	return;
        }
        Collections.sort(edges);
        
        long result = 0;
        for(Edge e : edges) {
        	if (union(e.start, e.end)) {
        		result += e.value;
        	}
        }

        // 모든 섬이 연결되었는지 확인
        System.out.println(result > K ? "NO" : "YES");
    }
}