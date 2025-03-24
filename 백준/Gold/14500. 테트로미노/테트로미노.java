import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 탐색 (dfs)
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                solve(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void solve(int r, int c, int sum, int count){

        // 테트로미노 완성
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for (int dir=0; dir<4; dir++){
            int curR = r + dx[dir];
            int curC = c + dy[dir];

            // 범위 벗어나면 예외
            if (curR < 0 || curR >= N || curC < 0 || curC >= M) continue;

            // 아직 방문하지 않은 곳일 때
            if (visited[curR][curC]) continue;

            // ㅗ 모양 테트로미노 만들기
            if (count == 2){
                visited[curR][curC] = true;
                solve(r, c, sum + map[curR][curC], count + 1);
                visited[curR][curC] = false;
            }

            visited[curR][curC] = true;
            solve(curR, curC, sum+map[curR][curC], count + 1);
            visited[curR][curC] = false;
        }
    }



}
