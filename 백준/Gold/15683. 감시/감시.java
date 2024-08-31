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

        // 백트래킹 시작
        dfs(0);
        System.out.println(minblind);
    }

    private static void dfs(int depth) {
        if (depth == cctvs.size()) {
            // 사각지대 계산
            minblind = Math.min(minblind, countBlindSpots());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] originalMap = copyMap(map);

        // CCTV 종류에 따른 방향 탐색
        switch (cctv.number) {
            case 1:
                for (int dir = 0; dir < 4; dir++) {
                    monitor(cctv.r, cctv.c, dir);
                    dfs(depth + 1);
                    restoreMap(originalMap);
                }
                break;
            case 2:
                for (int dir = 0; dir < 2; dir++) {
                    monitor(cctv.r, cctv.c, dir);
                    monitor(cctv.r, cctv.c, dir + 2);
                    dfs(depth + 1);
                    restoreMap(originalMap);
                }
                break;
            case 3:
                for (int dir = 0; dir < 4; dir++) {
                    monitor(cctv.r, cctv.c, dir);
                    monitor(cctv.r, cctv.c, (dir + 1) % 4);
                    dfs(depth + 1);
                    restoreMap(originalMap);
                }
                break;
            case 4:
                for (int dir = 0; dir < 4; dir++) {
                    monitor(cctv.r, cctv.c, dir);
                    monitor(cctv.r, cctv.c, (dir + 1) % 4);
                    monitor(cctv.r, cctv.c, (dir + 2) % 4);
                    dfs(depth + 1);
                    restoreMap(originalMap);
                }
                break;
            case 5:
                for (int dir = 0; dir < 4; dir++) {
                    monitor(cctv.r, cctv.c, dir);
                }
                dfs(depth + 1);
                restoreMap(originalMap);
                break;
        }
    }

    private static void monitor(int r, int c, int dir) {
        while (true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) break;
            if (map[nr][nc] == 0) map[nr][nc] = -1;
            r = nr;
            c = nc;
        }
    }

    private static int countBlindSpots() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static int[][] copyMap(int[][] original) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = original[i][j];
            }
        }
        return newMap;
    }
    // 원래대로 돌리기
    private static void restoreMap(int[][] originalMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = originalMap[i][j];
            }
        }
    }
}