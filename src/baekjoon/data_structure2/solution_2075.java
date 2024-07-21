import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class solution_2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. N 크기
		int N = Integer.parseInt(br.readLine());
		// N 번째 큰 숫자를 찾는거라서 map인데, 정렬도 시켜야 함
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 2. map 채우기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(num);
				if (pq.size() > N) {
					pq.poll();
				}
			}
		}
		System.out.println(pq.poll());
		br.close();
	} 
}
