import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
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

	// 궁수의 위치 조합으로 선택
	private static void dfs(int depth, int start) {
		if (depth == 3) {
			kill = Math.max(kill, shooting());
			return;
		}
		for (int i = start; i < M; i++) {
			arrow[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}
	// 궁수가 공격 범위 내에서 가장 가까운, 왼쪽부터 적 공격
	private static int shooting() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}

		int death = 0;
		for (int turn = 0; turn < N; turn++) {
			// 궁수들의 가장 가까운 적 위치
			int[][] attacks = new int[3][2];
			for (int i = 0; i < 3; i++) {
				attacks[i][0] = -1; // 초기값: x좌표
				attacks[i][1] = -1; // 초기값: y좌표
			}
			// 적 위치 찾기
			for (int a = 0; a < 3; a++) {
				int minDist = Integer.MAX_VALUE;
				int targetX = -1, targetY = -1;

				for(int i=N-1; i>=0; i--) {
					for(int j=0; j<M; j++) {
						if (temp[i][j] != 1) continue;
						int dist = (N-i) + Math.abs(arrow[a]-j);
						if (dist <= D){
							if (dist < minDist || (dist==minDist && j <targetY)) {
								minDist = dist;
								targetX = i; targetY = j;
							}
						}
					}
				}

				// 공격할 적 위치 저장하기
				if (targetX != -1 && targetY != -1) {
					attacks[a][0] = targetX;
					attacks[a][1] = targetY;
				}
			}


			// 적들을 제거
			for (int i = 0; i < 3; i++) {
				int targetX = attacks[i][0];
				int targetY = attacks[i][1];

				if (targetX != -1 && targetY != -1 && temp[targetX][targetY] == 1) {
					temp[targetX][targetY] = 0;
					death++;
				}
			}

			// 적이 한 칸 전진
			for (int i = N - 1; i > 0; i--) {
				temp[i] = temp[i - 1].clone();
			}
			temp[0] = new int[M]; // 제일 위 행은 아무것도 없음
		}

		return death;
	}

}
