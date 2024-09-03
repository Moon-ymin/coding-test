import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break; // 0 입력되면 테스트 케이스 끝

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 거리 상관없이 비용이 가장 작은 다익스트라 알고리즘 진행
			System.out.println("Problem " + cnt++ + ": " + getMinLost(0, 0, N - 1, N - 1));

		}
	}

	private static int getMinLost(int sr, int sc, int er, int ec) {
		final int INF = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][N];
		int[][] minLost = new int[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minLost[i][j] = INF;
			}
		}
		minLost[sr][sc] = 0;
		pq.offer(new int[] { sr, sc, minLost[sr][sc] });

		while (!pq.isEmpty()) {
			int[] point = pq.poll();
			int r = point[0];
			int c = point[1];
			int lost = point[2];

			if (visited[r][c])
				continue;
			visited[r][c] = true;
			if (r == er && c == ec)
				return lost+map[0][0];

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dx[dir];
				int nc = c + dy[dir];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& minLost[nr][nc] > lost + map[nr][nc]) {
					minLost[nr][nc] = lost + map[nr][nc];
					pq.offer(new int[] { nr, nc, minLost[nr][nc] });
				}

			}

		}

		return -1;
	}

}