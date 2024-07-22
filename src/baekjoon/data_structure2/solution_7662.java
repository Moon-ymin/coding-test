import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 테스트의 수 T
		int T = Integer.parseInt(br.readLine());
		
		// 2. 테스트 별 데이터의 수 k
		for(int i=0; i<T; i++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			for(int j=0; j<k; j++) {
				// 3. 연산을 나타내는 문자 (D 또는 I), 정수 N
				st = new StringTokenizer(br.readLine(), " ");
				String operation = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (operation.equals("I")) { // 4-1. I N : 정수 N을 Q에 삽입
					// 겹치는지 확인
					if (map.containsKey(num)) {
						map.put(num, map.get(num)+1);
					} else {
						map.put(num, 1);
					}
				} else { // 4-2. D N : 정수 N을 Q에서 삭제
					if (map.isEmpty()) {
						continue;
					} else if(num == 1) { // 4-3. D 1 : Q에서 최댓값 삭제
						int maxKey = map.lastKey();
						if (map.get(maxKey) == 1) {
							map.remove(maxKey);
						} else {
							map.put(maxKey, map.get(maxKey)-1);
						}
					} else { // D -1 : Q에서 최솟값 삭제 -> 같은 숫자 있으면 둘 중 하나만 삭제
						int minKey = map.firstKey();
						if (map.get(minKey) == 1) {
							map.remove(minKey);
						} else {
							map.put(minKey, map.get(minKey)-1);
						}
					}
				}		
			}// 5. 최종적으로 최댓값, 최솟값 출력
			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey()+" "+map.firstKey());
			}
		}
	}
}
