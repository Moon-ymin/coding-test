import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][], N, M, R;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		// 1. 배열의 크기 N, M, 연산의 수 R
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 2. N개의 줄에 입력할 N*M 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 3. 수행할 연산 R번
		st = new StringTokenizer(br.readLine());
		for (int r=0; r<R; r++){
			int op = Integer.parseInt(st.nextToken());
			switch (op){
				case 1: one(); break;
				case 2: two(); break;
				case 3: three(); break;
				case 4: four(); break;
				case 5: five(); break;
				case 6: six(); break;
			}
		}

		// 4. 출력
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void one(){
		// 상하반전 - 행 자체를 이동
		for(int i=0; i<N/2; i++){
			int[] temp = map[i];
			map[i] = map[N-i-1];
			map[N-i-1] = temp;
		}
	}
	private static void two(){
		// 좌우반전 - 행 별로 열 값만 변경
		for(int i=0; i<N; i++){
			for(int j=0; j<M/2; j++){
				int temp = map[i][j];
				map[i][j] = map[i][M-j-1];
				map[i][M-j-1] = temp;
			}
		}

	}
	private static void three(){
		int[][] rotatemap = new int[M][N];

		// 시계방향 90도 회전
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				rotatemap[j][N-1-i] = map[i][j];
			}
		}
		map = rotatemap;
		int temp = N; N=M; M=temp;
	}
	private static void four(){
		int[][] rotatemap = new int[M][N];

		// 반시계방향 90도 회전
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				rotatemap[M-1-j][i] = map[i][j];
			}
		}
		map = rotatemap;
		int temp = N; N=M; M=temp;
	}
	private static void five(){
		int[][] changemap = new int[N][M];

		// 1번 to 2번
		for(int i=0; i<N/2; i++){
			for(int j=0; j<M/2; j++){
				changemap[i][j+M/2] = map[i][j];
			}
		}
		// 2번 to 3번
		for(int i=0; i<N/2; i++){
			for(int j=M/2; j<M; j++){
				changemap[i+N/2][j] = map[i][j];
			}
		}
		// 3번 to 4번
		for(int i=N/2; i<N; i++){
			for(int j=M/2; j<M; j++){
				changemap[i][j-M/2] = map[i][j];
			}
		}
		// 4번 to 1번
		for(int i=N/2; i<N; i++){
			for(int j=0; j<M/2; j++){
				changemap[i-N/2][j] = map[i][j];
			}
		}
		map = changemap;
	}
	private static void six(){
		int[][] changemap = new int[N][M];
		// 1 to 4
		for(int i=0; i<N/2; i++){
			for(int j=0; j<M/2; j++){
				changemap[i+N/2][j] = map[i][j];

			}		}
		// 2 to 1
		for(int i=0; i<N/2; i++){
			for(int j=M/2; j<M; j++){
				changemap[i][j-M/2] = map[i][j];
			}
		}
		// 3 to 2
		for(int i=N/2; i<N; i++){
			for(int j=M/2; j<M; j++){
				changemap[i-N/2][j] = map[i][j];
			}
		}
		// 4 to 3
		for(int i=N/2; i<N; i++){
			for(int j=0; j<M/2; j++){
				changemap[i][j+M/2] = map[i][j];
			}
		}
		map = changemap;
	}
}
