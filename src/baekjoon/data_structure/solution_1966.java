import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());	// 문서의 개수
			int M = Integer.parseInt(st.nextToken());	// 궁금한 문서
			
			// 프린트기 명령 큐
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());	// 문서의 중요도 차례로
			
			for(int i=0; i<N; i++) {
				// {초기 위치, 중요도}
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			int count = 0;	// 출력 횟수
			
			while(!q.isEmpty()) {
				int[] front = q.poll();	// 가장 첫 번째 원소
				boolean isMax = true;	// 가장 큰 원소인지를 판단하는 변수
				
				// 큐에 남아있는 원소들과 중요도 비교
				for(int i=0; i<q.size(); i++) {
					if(front[1] < q.get(i)[1]) {
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다
						q.offer(front);
						for(int j=0; j<i; j++) {
							q.offer(q.poll());
						}
						isMax = false;	// front 원소가 가장 큰 원소가 아님 표시
						break;
					}
				}
				if (isMax == false) {
					continue;
				}
				count++;
				if (front[0] == M) {
					break;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);		
	}
}
