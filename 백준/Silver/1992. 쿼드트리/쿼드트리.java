import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, map[][], index;
	static String s = "";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 영상의 크기 N
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 2. map 채워넣기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// 3. dfs 진행
		index = 0;
		dfs(0, 0, N, 0); // 시작 좌표 x, y, 사이즈 (변의 길이), 깊이
		System.out.println(s);
	}
	private static void dfs(int x, int y, int size, int depth) {
		int sum = 0;
		// 모든 칸의 합 구하기
		for(int i=x, xend=x+size; i<xend; i++) {
			for(int j=y, yend=y+size; j<yend; j++) {
				sum += map[i][j];
			}
		}
		
		// 1) 같은 공간이 0으로만 채워져있는지 확인 => 모든 칸의 합=0
		if (sum == 0) {
			s+="0";
		}// 2) 같은 공간이 1로만 채워져있는지 확인 -> 모든 칸의 합 = N/2* N/2
		else if (sum==size*size) {
			s+="1";
		} // 3) 섞여있음 -> 다시 분할
		else {
			int half = size/2;
			s+="(";
			dfs(x,y,half, depth+1); // 1
			dfs(x,y+half, half, depth+1); // 2
			dfs(x+half, y, half, depth+1); // 3
			dfs(x+half, y+half, half, depth+1); // 4
			s+=")";
		}
	}
}