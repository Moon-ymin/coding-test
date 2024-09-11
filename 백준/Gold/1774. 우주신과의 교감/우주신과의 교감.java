import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class God {
		int x, y;

		public God(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;

		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	static int N, M, parent[];
	static List<Edge> dist; // 연결된 점 좌표, 길이 
	static void make() {
		parent = new int[N+1];
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int a) {
		if (parent[a] == a) return a;
		return parent[a] = findSet(parent[a]);
	}
	static boolean Union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		God[] gods = new God[N+1];
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			gods[i] = new God(x, y); 
		}
		make();
		
		// 이미 연결된 상태 있으면 반영
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int g1 = Integer.parseInt(st.nextToken());
			int g2 = Integer.parseInt(st.nextToken());
			Union(g1, g2);
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 연결할 수 있는 모든 통로 큐에 추가
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<N+1; j++) {
				pq.offer(new Edge(i, j, distance(gods[i], gods[j])));
			}
		}
		
		double cost = 0; int cnt=0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			// 통로의 시작점과 끝점의 그룹을 합침(최상위 노드가 다를 경우)
			if (Union(edge.start, edge.end)) {
				cost += edge.weight;
			}
		}
		System.out.printf("%.2f\n",cost);
		
		
		
	}
	static double distance(God g1, God g2) {
		double garo = Math.pow( Math.abs(g1.x - g2.x), 2);
		double sero = Math.pow( Math.abs(g1.y - g2.y), 2);
		return Math.sqrt(garo + sero);
	}

}