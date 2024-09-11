import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 방향없는 그래프 - 간선의 최소 비용 구하기 - 크루스칼 알고리즘 활용
 *  
 * @author SSAFY
 *
 */
public class Main {
	static class Edge implements Comparable<Edge>{
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
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean UnionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	static int N, M, parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		Edge[] edges = new Edge[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edges);
		make();
		
		long cost = 0; int cnt = 0;
		for(Edge e : edges) {
			if (UnionSet(e.start, e.end)) {
				cost += e.value;
				
				if (++cnt == N-1) break;
			}
		}
		System.out.println(cost);
		
		
	}

}