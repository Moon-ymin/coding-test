import java.util.Scanner;


public class solution_13300 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 1. 학생 수 N, 한 방 최대 인원 수 K
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[6][2];
		
		// 2. 성별 S(여 0 남 1), 학년 Y
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			map[y-1][s] += 1;
		}
		
		// 최소한의 방의 수
		// K 초과면 -> 인원수 / K + 1
		int room = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if (map[i][j] == 0){
					continue;
				} else if(map[i][j] > K ) {
					room = room + (map[i][j] / K + 1);
				} else {
					room += 1;
				}
			}
		}
		System.out.println(room);
	}
}
