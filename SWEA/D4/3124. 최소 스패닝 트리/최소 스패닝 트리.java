import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[] parents;
	static int V, E;
	static class Edge implements Comparable<Edge>{
		int start, end, value;

		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.value, o.value );
		}
		
	}
	
	static void make() {
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = -1;
		}
	}
	static int findSet(int a) {
		if (parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		
		// 노드 연결하기
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			// 노드 만들기
			List<Edge> edges = new ArrayList<>();
			for(int e=0; e<E; e++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int value = sc.nextInt();
				
				edges.add(new Edge(start, end, value));
			}
			// 정렬 먼저
			Collections.sort(edges);
			make();
			
			int cnt=0; long cost = 0;
			for(Edge edge : edges) {
				if (unionSet(edge.start, edge.end)) {
					cost += edge.value;
					if (++cnt == V) break;
				}
			}
			System.out.println("#"+t+" "+cost);
		}
	}
}