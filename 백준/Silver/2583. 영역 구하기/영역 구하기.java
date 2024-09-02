import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int grid[][], N, M, K, width;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken()); // 행
		N = Integer.parseInt(st.nextToken()); // 열 
		K = Integer.parseInt(st.nextToken()); // 얼어붙은 영역의 개수
		
		grid = new int[N][M];
		
		for(int k=0; k<K; k++) { // 얼어붙은 곳 grid 1로 채우기
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					grid[i][j] = 1;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (grid[i][j] == 0) {
					width=0; // 섬의 넓이
					floodfill(grid, i, j);
					// System.out.println(width);
					list.add(width);
					
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	private static void floodfill(int[][] grid, int x, int y) {
		width += 1;
		grid[x][y] = 1;
		
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny] == 0) {
				floodfill(grid, nx, ny);
			}
		}
	}

}