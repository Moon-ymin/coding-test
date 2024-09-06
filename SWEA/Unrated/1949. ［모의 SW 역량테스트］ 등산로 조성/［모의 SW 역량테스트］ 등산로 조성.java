import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int map[][], N, K, maxLen;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean isVisited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			List<Node> maxNodes = new ArrayList<>();
			int max = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// 제일 높은 노드 저장하고, 높이 뭔지 저장하기
			map = new int[N][N];
			isVisited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						maxNodes.clear();
						max = map[i][j];
						maxNodes.add(new Node(i, j));
					} else if (max == map[i][j]) {
						maxNodes.add(new Node(i, j));
					}
				}
			}

			maxLen = Integer.MIN_VALUE;
			for (Node n : maxNodes) {
				isVisited[n.x][n.y] = true;
				dfs(n.x, n.y, 1, 0);
				isVisited[n.x][n.y] = false;
			}

			System.out.println("#" + t + " " + maxLen);

		}
	}

	private static void dfs(int x, int y, int len, int isCut) {
		maxLen = Math.max(len, maxLen);

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || isVisited[nx][ny])
				continue;

			// 다음 산 높이가 지금 높이보다 작은데 깎은 횟수가 0 
			if (map[x][y] <= map[nx][ny]) {
				if( isCut == 1 ) continue; 
				
				for (int cut = 1; cut <= K; cut++) {
					if (map[nx][ny]-cut < map[x][y]) {
						map[nx][ny] -= cut;
						isVisited[nx][ny] = true;
						
						dfs(nx, ny, len + 1, isCut + 1);
						
						isVisited[nx][ny] = false;
						map[nx][ny] += cut;
						break;
					}
				}
			} else {
				isVisited[nx][ny] = true;
				dfs(nx, ny, len + 1, isCut);
				isVisited[nx][ny] = false;
			}
		}

	}

}