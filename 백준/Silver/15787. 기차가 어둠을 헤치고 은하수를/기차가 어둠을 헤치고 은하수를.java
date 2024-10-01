import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][21];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			operation(op);
		}
		
		System.out.println(cnt());
	}
	
	private static void operation(int op) {
		int i = Integer.parseInt(st.nextToken());
		switch(op) {
		case 1:{
			int x = Integer.parseInt(st.nextToken());
			map[i][x] = 1;
			break;
		}
		case 2:{
			int x = Integer.parseInt(st.nextToken());
			map[i][x] = 0;
			break;
		}
		case 3:{
			for(int j=20; j>1; j--) {
				map[i][j] = map[i][j-1];
			}
			map[i][1] = 0;
			break;
		}
		case 4:{
			for(int j=1; j<20; j++) {
				map[i][j]= map[i][j+1];
			}
			map[i][20] = 0;
			break;
		}
		}
	}
	private static int cnt() {
		Map<String, Integer> check = new HashMap<>();
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			String train = "";
			for(int j=1; j<=20; j++) {
				train += map[i][j];
			}
			if (check.containsKey(train)) continue;
			check.put(train, 1);
			result++;
			
			
		}
		return result;
	}

}
/** 명령어의 종류
 * 1 i x : i 번째 기차 x 번째 좌석에 앉혀라
 * 2 i x : i 번째 기차 x 번째 사람 없애라
 * 3 i : i번째 기차 손님들 전부 한 칸씩 뒤로 (당기기)
 * 4 i : i번째 기차 손님들 전부 한 칸씩 앞으로 
 * 
 * 기차 지나가고 승객이 앉은 상태 기록 -> map에 
*/