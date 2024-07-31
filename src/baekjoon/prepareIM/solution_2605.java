import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class solution_2605 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 학생 수 N 입력 받기
		int N = Integer.parseInt(br.readLine());
		// 2. 뽑은 결과 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 결과 담을 ArrayList
		List<Integer> result = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			int index = Integer.parseInt(st.nextToken());
			result.add(i-1-index, i);
		}
		
		for(Integer r : result) {
			System.out.print(r+" ");
		}
		
	}
}
