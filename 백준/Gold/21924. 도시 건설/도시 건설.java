import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
		parents = new int[N+1];
		Arrays.fill(parents, -1);
	}
	static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean Union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
	}
	static int N, M, parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[M];
		
		long total = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			total += c;
			edges[i] = new Edge(a, b, c);
		}
		Arrays.sort(edges);
		make();
		
		int cnt=0;
		long cost = 0; // 연결되는 건물 수 cnt, 비용 cost
		for(Edge edge : edges) {
			if (Union(edge.start, edge.end)) {
				cost += edge.value;
				if (++cnt == N-1) break;
				
			}
		}
		System.out.println(cnt==N-1 ? total - cost : -1);
	}

}