import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, y, h;
		public Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	static int map[][], K, W, H;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우 
	static int[] dy = {0, 0, -1, 1};
	static int[] hdx = {-1,-2,-2,-1,1,2,2,1};
	static int[] hdy = {-2,-1,1,2,2,1,-1,-2};

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 0));
		boolean[][][] visited = new boolean[H][W][K+1]; // 말처럼 이동한 횟수별 방문 체크
		visited[0][0][0] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				int cx = cur.x;
				int cy = cur.y;
				
				// 도착지점에 도달
				if (cx == H - 1 && cy == W - 1) {
					System.out.println(cnt);
					return;
				}
				
				// 원숭이처럼 이동
				for (int dir = 0; dir < 4; dir++) {
					int nx = cx + dx[dir];
					int ny = cy + dy[dir];
					int ch = cur.h;
					
					if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1 || visited[nx][ny][ch]) continue;
					
					q.offer(new Node(nx, ny, ch));
					visited[nx][ny][ch] = true;
				}
				
				// 말처럼 이동 (말 이동 횟수가 남아있을 때만)
				if (cur.h < K) {
					for (int dir = 0; dir < 8; dir++) {
						int nx = cx + hdx[dir];
						int ny = cy + hdy[dir];
						int ch = cur.h + 1;
						
						if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1 || visited[nx][ny][ch]) continue;
						
						q.offer(new Node(nx, ny, ch));
						visited[nx][ny][ch] = true;
					}
				}
			}
			cnt++; // 한 레벨의 탐색이 끝날 때마다 이동 횟수를 증가
		}
		System.out.println(-1);
	}
}