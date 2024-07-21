import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class solution_14425 {
	public static void main(String[] args) throws IOException {
		// 1. N : 문자열의 개수 M : 검사해야 하는 문자열들
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());		
		
		// 2. 집합 S에 포함되는 N개의 문자열
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), i);
		}
		
		// 3. 검사해야 하는 문자열 M개
		int cnt=0;
		for (int i=0; i<M; i++) {
			if (map.containsKey(br.readLine())){
				cnt++;
			}
		}
		System.out.println(cnt);
	} 
}
