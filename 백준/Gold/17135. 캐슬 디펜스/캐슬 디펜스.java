
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author SSAFY 궁수 위치 조합으로 찾기
 * 궁수 위치 1행씩 올리면서 적 제거
 * 카운트 최대값과 비교 및 갱신
 */

public class Main{
	static int N, M, D, map[][], arrow[], kill;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		arrow = new int[3];
		kill = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(kill);
	}

	private static void dfs(int depth, int start) {
		if (depth == 3) {
			// 궁수 3명의 위치 모두 선택함 - 제거할 수 있는 적의 수 카운트하기
			int death = shooting();
			kill = Math.max(kill, death);
			return;
		}
		for (int i = start; i < M; i++) {
			arrow[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}

	private static int shooting() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}

		int death = 0;
		for (int turn = 0; turn < N; turn++) {
			boolean[][] attacked = new boolean[N][M];

			for (int k = 0; k < 3; k++) {
				int arr = arrow[k];
				int minDist = Integer.MAX_VALUE;
				int targetX = -1, targetY = -1;

				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (temp[i][j] == 1) {
							int dist = (N - i) + Math.abs(arr - j);
							if (dist <= D) {
								if (dist < minDist || (dist == minDist && j < targetY)) {
									minDist = dist;
									targetX = i;
									targetY = j;
								}
							}
						}
					}
				}

				if (targetX != -1 && targetY != -1) {
					attacked[targetX][targetY] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (attacked[i][j]) {
						temp[i][j] = 0;
						death++;
					}
				}
			}

			// 적이 한 칸 전진
			for (int i = N - 1; i > 0; i--) {
				temp[i] = temp[i - 1].clone();
			}
			temp[0] = new int[M];
		}

		return death;
	}

}
