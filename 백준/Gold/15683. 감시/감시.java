import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static class CCTV {
        int r, c, number;
        public CCTV(int r, int c, int number) {
            this.r = r;
            this.c = c;
            this.number = number;
        }
    }

    static int N, M, minblind;
    static int[][] map, backupMap;
    static List<CCTV> cctvs;
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvs = new ArrayList<>();
        minblind = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if ("12345".contains("" + map[i][j])) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0);
        System.out.println(minblind);
    }

    private static void dfs(int depth){
        if (depth == cctvs.size()) { // cctv 방향 전부 설정 완료
            // 사각지대 계산하기
            minblind = Math.min(minblind, countBlindSpot());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        // CCTV 종류에 따라 방향 설정하기
        switch (cctv.number) {
            case 1:
                for (int dir = 0; dir < 4; dir++) {
                    placeCCTV(cctv.r, cctv.c, dir); // 그 방향으로 CCTV 둬보고
                    dfs(depth + 1); // 다음 CCTV 방향 설정
                    restore(temp);
                }
                break;
            case 2:
                for (int dir = 0; dir < 2; dir++) {
                    placeCCTV(cctv.r, cctv.c, dir);
                    placeCCTV(cctv.r, cctv.c, dir+2);
                    dfs(depth + 1);
                    restore(temp);

                }
                break;
            case 3:
                for (int dir = 0; dir < 4; dir++) {
                    placeCCTV(cctv.r, cctv.c, dir);
                    placeCCTV(cctv.r, cctv.c, (dir+1)%4);
                    dfs(depth + 1);
                    restore(temp);
                }
                break;
            case 4:
                for (int dir = 0; dir < 4; dir++) {
                    placeCCTV(cctv.r, cctv.c, dir);
                    placeCCTV(cctv.r, cctv.c, (dir+1)%4);
                    placeCCTV(cctv.r, cctv.c, (dir+2)%4);
                    dfs(depth + 1);
                    restore(temp);
                }
                break;
            case 5:
                for (int dir = 0; dir < 4; dir++) {
                    placeCCTV(cctv.r, cctv.c, dir);
                }
                dfs(depth + 1);
                restore(temp);
                break;
        }
    }
    private static int countBlindSpot(){ // 사각지대 계산하기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    private static void restore(int[][] temp){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }
    private static void placeCCTV(int r, int c, int dir){
        while(true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            // 범위 벗어나거나 벽 만나면 탈출
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) break;
            if (map[nr][nc] == 0) map[nr][nc] = -1; // cctv 감시 영역으로 -1로 표시
            r = nr;
            c = nc;
        }
    }
}