import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;

public class solution_11286 {
	static class Num {
		Integer x;
		Integer y;
		public Num(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 연산의 개수 N
		int N = Integer.parseInt(br.readLine());
		// 트리맵 (<절댓값, 그냥 값 자체>, 갯수)
		TreeMap<Num, Integer> map = new TreeMap<>(new Comparator<Num>() {
			@Override
			public int compare(Num n1, Num n2) {
				if (n1.x.compareTo(n2.x) != 0) {
					return n1.x.compareTo(n2.x);
				}
				return n1.y.compareTo(n2.y);
			}
		});
		
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				// 2-1. 0이면 배열에서 절댓값 출력
				if (map.size() == 0) {
					System.out.println(0);
				} else {
					if (map.firstEntry().getValue() > 1) {
						map.replace(map.firstKey(), map.firstEntry().getValue()-1);
						System.out.println(map.firstKey().y);
					} else {
						System.out.println(map.pollFirstEntry().getKey().y);
					}
				}
			} else {
				// 2-2. 0이 아니면 그 값 추가
				Num insertNum = new Num(Math.abs(num), num);
				if (map.containsKey(insertNum)) {
					map.replace(insertNum, map.get(insertNum)+1);
				} else {
					map.put(insertNum, 1);
				}
			}
		}
	}

}
