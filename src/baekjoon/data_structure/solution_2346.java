import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// N 입력 받기
		/*
		 * 3 2 1 -3 -1 
		 * 0 2 1 -3 -1
		 * 0 2 1  0 -1
		 * 0 2 1  0  0
		 * 0 2 0  0  0
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<int[]> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {	// 풍선 채워넣기
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();	// 출력될 결과
		sb.append("1 "); // 시작은 무조건 첫번째 풍선
		int in = arr[0];	// 제일 첫번째 풍선의 종이에 적혀있는 값
		
		for(int i=1; i<N; i++) {
			q.add(new int[] {(i+1), arr[i]});	// {풍선 idx, 내용}
		}
		
		while(!q.isEmpty()) {
			// 첫번째 풍선에 적힌 숫자
			if (in > 0) {	// 양수 나올 때 갱신
				// 순서 뒤로 돌리기
				for(int i=1; i<in; i++) {
					q.add(q.poll());	// 풍선들 뒤로 옮김
				}
				int[] nxt = q.poll();	// 다음 터뜨릴 풍선{풍선 idx, 내용}
				in = nxt[1]; 			// 다음 터뜨릴 풍선의 {내용}
				sb.append(nxt[0]+" ");  // 다음 터뜨릴 풍선의 {풍선 idx} 추가
			} else {	// 음수 나올 때 갱신
				for(int i=1; i<-in; i++) {
					q.addFirst(q.pollLast());
				}
				int[] nxt = q.pollLast();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
		}
		System.out.println(sb.toString());
		
	}

}
