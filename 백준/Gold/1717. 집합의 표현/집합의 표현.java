import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, parents[];
	static void make() {
		parents = new int[n+1];
		Arrays.fill(parents, -1);
	}
	static int findSet(int a) {
		if (parents[a] < 0) return a;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		make();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (op==0) { // a, b 집합 합쳐라
				Union(a, b);
			} else { // 같은집합인지 확인하라
				if (findSet(a) == findSet(b)) System.out.println("YES");
				else System.out.println("NO");
				
			}
		}
	}

}