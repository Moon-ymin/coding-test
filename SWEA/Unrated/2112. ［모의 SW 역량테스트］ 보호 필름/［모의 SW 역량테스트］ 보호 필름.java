import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 약품 투여 횟수, 약품 투여할 행 선택 -> 조합
 * -> 선택된 상태에서 통과여부 확인하기
 */
public class Solution {
	static int D, W, K, mindepth;
	static int[][] map, origin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			origin = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					origin[i][j] = map[i][j];
				}
			}
			mindepth = K;

			// 바꾸기 전상태에서 일단 만족하는지 확인하기
			if (check()) mindepth = 0;
			else dfs(0, 0);

			System.out.println("#"+t+" "+mindepth);
		}
	}
	static void dfs(int depth, int start) { // 약품 투여 횟수 선택
		if (depth >= mindepth) return;
		if (check()){
			mindepth = Math.min(depth, mindepth);
			return;
		}
		for (int i = start; i < D; i++) {
			changeRow(i, 0); // A 약물 = 0
			dfs(depth + 1, i+1);
			changeRow(i, 1); // B 약물 = 0
			dfs(depth + 1, i+1);

			for(int r=0; r<W; r++){
				map[i][r] = origin[i][r];
			}
		}
	}
	static void changeRow(int row, int aorb) {
		for (int i=0; i<W; i++) map[row][i] = aorb;
	}
	static boolean check(){ // 성능검사 통과 가능 여부
		for(int j=0; j<W; j++){
			boolean valid = false;
			for(int i=0; i<=D-K; i++){
				int cnt = 1;
				for(int k=i+1; k<i+K; k++){
					if (map[i][j] == map[k][j]) cnt++;
					else break;
				}
				if (cnt == K) { valid = true; break;}
			}
			if (!valid) return false;
		}
		return true;
	}
}
