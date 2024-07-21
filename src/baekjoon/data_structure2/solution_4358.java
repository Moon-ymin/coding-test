import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class solution_4358 {
	public static void main(String[] args) throws IOException {
		// 1. 나무들 입력받기 : ctrl+z 하는 경우 입력 종료로 봄
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double total = 0.0;
		
		// 2. 나무 종을 사전 순 정렬 해야 함 - Treemap (String, Integer) (나무종이름, 나무수)
		TreeMap<String, Integer> map = new TreeMap<>();
		while(true) {
			String name = br.readLine();	// 나무 이름
			if (name != null && !name.equals("")) { // 종료 조건 : 걍 아무것도 입력안했을 때
				total++;
				if (map.containsKey(name)) {
					map.replace(name, map.get(name) + 1);
				} else {
					map.put(name, 1);
				}
			} else {
				break;
			}
		}
		
		// 3. 종이 차지하는 비율 계산해 출력 value / total * 100 
		for(Map.Entry<String,Integer> e : map.entrySet()) {
			double ratio = e.getValue() / total * 100.0;
			System.out.printf("%s %.4f\n", e.getKey() ,ratio);
		}		
	} 
}
