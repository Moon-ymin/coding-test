import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		int[][] maptime = new int[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'O') maptime[i][j] = 3;
			}
		}
		
		int time = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(time++ < N) {
			if (time % 2 == 0) { // 짝수 시간에 폭탄 없는 곳은 채워넣기
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O'; maptime[i][j] = time+3;
						}
					}
				}
			} else {
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(maptime[i][j] == time) {
							map[i][j] = '.';
							for(int dir=0; dir<4; dir++) {
								int nx = i+dx[dir];
								int ny = j+dy[dir];
								if (nx < 0 || nx >= R || ny < 0 || ny >=C ) continue;
								 
								if (map[nx][ny]=='O' && maptime[nx][ny] != time) {
									map[nx][ny] = '.';
									maptime[nx][ny] = 0;
								}
							}
						}
					}
				}		
				
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}