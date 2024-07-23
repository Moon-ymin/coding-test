import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static class Problem {
		int p; 
		int l;
		
		public Problem(int p, int l) {
			this.p = p;
			this.l = l;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeSet<Problem> ts = new TreeSet<>((o1, o2) -> {
			if (o1.l == o2.l) {
				return o1.p - o2.p;
			}
			return o1.l - o2.l;
		});
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// 1. 문제의 개수 N
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			// 2. 문제 번호 P, 난이도 L
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			Problem problem = new Problem(p, l);
			ts.add(problem);
			map.put(p,  l);
		};
			
		// 3. 명령문의 개수 M
		int M = Integer.parseInt(br.readLine());
		// 4. 명령문들
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String operation = st.nextToken();
			switch (operation) {
			case "add":
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				Problem problem = new Problem(p, l);
				ts.add(problem);
				map.put(p, l);
				break;
			case "recommend":
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) { // 가장 어려운 문제의 번호를 출력 => 최대힙
					System.out.println(ts.last().p);
				} else if (num == -1) { // 가장 쉬운 문제의 번호를 출력 => 최소힙
					System.out.println(ts.first().p);
				}
				break;
			case "solved":
				int s_p = Integer.parseInt(st.nextToken());
				int s_l = map.get(s_p);
				ts.remove(new Problem(s_p, s_l));
				break;
			default:
				break;
			}
		}
	}
}
