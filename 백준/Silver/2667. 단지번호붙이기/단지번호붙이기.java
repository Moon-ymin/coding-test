import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][], N;
	static boolean isVisit[][];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		isVisit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		int block = 0; // 단지수
		List<Integer> cnthouse = new ArrayList<>(); // 단지에 속하는 집의 수
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (map[i][j] != 1 || isVisit[i][j]) continue;
				q.offer(new int[] {i, j});
				isVisit[i][j] = true;
				int cnt = 0;
				
				while(!q.isEmpty()) {
					int[] house = q.poll();
					int x = house[0];
					int y = house[1];
					cnt++;
					
					for(int dir=0; dir<4; dir++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0 || isVisit[nx][ny]) continue;
						
						isVisit[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
				block++;
				cnthouse.add(cnt);
				
			}
		}
		Collections.sort(cnthouse); // 단지내 집의 수 정렬
		System.out.println(block);
		for(Integer cnt : cnthouse) {
			System.out.println(cnt);
		}
		

	}

}