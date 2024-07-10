import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 정수를 저장하는 Deque
		Deque<Integer> dq = new LinkedList<>();
		
		// 명령의 수 : N
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
				break;
			}
			
		}
		System.out.println(sb);
		
	}

}
