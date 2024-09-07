import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] pipe = new int[N+1][N+1][3];
        pipe[1][2][0] = 1;
        for(int x=1; x<=N; x++){
            for(int y=3; y<=N; y++){
                if(map[x][y]==1) continue;

                pipe[x][y][0] = pipe[x][y-1][0] + pipe[x][y-1][2];
                pipe[x][y][1] = pipe[x-1][y][1] + pipe[x-1][y][2];

                if(map[x-1][y]==1 || map[x][y-1]==1) continue;
                pipe[x][y][2] = pipe[x-1][y-1][0] + pipe[x-1][y-1][1] + pipe[x-1][y-1][2];
            }
        }

        System.out.println(pipe[N][N][0] + pipe[N][N][1] + pipe[N][N][2]);
    }
}
