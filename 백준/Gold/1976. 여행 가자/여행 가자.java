import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, parent[];

	static void make() {
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i] = i;
	}
	static int findSet(int a) {
		if (parent[a] == a) return a;
		return parent[a] = findSet(parent[a]);
	}
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		make();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num!=1) continue;
				unionSet(i, j);
				
			}
		}
		
		// 집합인지 확인
		st = new StringTokenizer(br.readLine());
		int dept = Integer.parseInt(st.nextToken())-1;
		while(st.hasMoreTokens()) {
			int arrive = Integer.parseInt(st.nextToken())-1;
			if (unionSet(dept, arrive)) { // 같은 집합이라서 합쳐지지 않으면
				System.out.println("NO");
				return;
			}
			dept = arrive;
		}
		System.out.println("YES");

	}

}