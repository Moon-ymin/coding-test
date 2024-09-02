import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], wall[], max;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<int[]> blank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		blank = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) blank.add(new int[] {i, j});
			}
		}
		wall = new int[3];
		max = Integer.MIN_VALUE;
		dfs(0, 0);
		System.out.println(max);
	}
	// 1. 빈칸 중 벽을 세울 3칸 선택 -> 조합 사용
	private static void dfs(int depth, int start) {
		if (depth == 3) {
			// 벽 세울 빈칸 3개 선택 완료
			max = Math.max(install(), max);
			return;
		}
		for(int idx=start; idx<blank.size(); idx++) {
			wall[depth] = idx; // blank의 인덱스만 저장하기
			dfs(depth+1, idx+1);
			
		}
	}
	// 2. 벽 세운 상태로 바이러스 퍼진 거 구현
	private static int install() {
		int[][] temp = new int[N][M];
		for(int i=0; i<temp.length; i++) {
			temp[i] = Arrays.copyOf(map[i], M);
		}
		for(int i=0; i<wall.length; i++) {
			int r = blank.get(wall[i])[0];
			int c = blank.get(wall[i])[1];
			temp[r][c] = 1;
		}
		boolean[][] isVisited = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (temp[i][j]==2 && !isVisited[i][j]) {
					q.offer(new int[] {i,j});
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];
						isVisited[x][y] = true;
						
						for(int dir=0; dir<4; dir++) {
							int nx = x + dx[dir];
							int ny = y + dy[dir];
							if (nx<0||ny<0||nx>=N||ny>=M||temp[nx][ny]!=0||isVisited[nx][ny]) continue;
							temp[nx][ny] = 2;
							q.offer(new int[] {nx, ny});
						}
					}
				}
			}
		}
		
		return countSafe(temp);
	}
	// 3. 안전 영역의 크기 
	private static int countSafe(int[][] temp) {
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (temp[i][j]==0) result++;
			}
		}
		return result;
	}

}