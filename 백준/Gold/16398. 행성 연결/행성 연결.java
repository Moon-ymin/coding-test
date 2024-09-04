import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 모든 행성의 연결 - 유지 비용의 최소화(간선 비용) - 플로우의 설치비용은 상관없음
 * -> 간선 선택 개수 상관없이 무조건 비용의 최소화 목표
 * => 크루스칼 (시작 지점 없음)
 * @author SSAFY
 *
 */
public class Main {
	static int map[][], parents[], N;
	static class Edge implements Comparable<Edge> {
		int start, end;
		long value;

		public Edge(int start, int end, long value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		public int compareTo(Edge o) {
			return Long.compare(this.value, o.value);
		}
		
	}
	static void make() {		
		for(int i=0; i<N; i++) parents[i] = i;
		
	}
	static int findSet(int a) {
		if (parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		List<Edge> edges = new ArrayList<>();
		
		int index = 0;
		long cost = 0, cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i<j) edges.add(new Edge(i, j, map[i][j]));
				
			}
		}
		Collections.sort(edges);
		parents = new int[N];
		make();
		
		for(Edge e : edges) {
			if(union(e.start, e.end)) {
				cost += e.value;
				
				if (++cnt == N-1) break;
			}
		}
		System.out.println(cost);	
		
	}

}