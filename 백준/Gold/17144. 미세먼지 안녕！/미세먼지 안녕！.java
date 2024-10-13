import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int R, C, T, map[][], dust[][], airR;
    static int[] topdx = {-1, 0, 1, 0};
    static int[] botdx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        dust = new int[R+1][C+1];

        for(int i=1; i<=R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) dust[i][j] = map[i][j];
                else if (map[i][j]==-1 && airR==0) airR = i;
            }
        }

        for(int t=1; t<=T; t++) {
            // 1. 확산
            diffusion();
            // 2. dust 비교해서 차이 빼기
            subMap();
            // 3. 순환
            recursion();
            // 4. dust 갱신
            updateDust();
        }

        int result = 0;
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                if (map[i][j] > 0) result += map[i][j];
            }
        }
        System.out.println(result);

    }
    private static void diffusion() {
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                if (dust[i][j] > 0) {
                    for(int dir=0; dir<4; dir++) {
                        int nx = i + topdx[dir];
                        int ny = j + dy[dir];
                        if (nx<1 || nx>R || ny<1 || ny>C || map[nx][ny]==-1) continue;
                        map[nx][ny] += dust[i][j] / 5;
                    }
                }
            }
        }
    }

    private static void subMap() {
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                if (dust[i][j]>0) {
                    int cnt = 0;
                    for(int dir=0; dir<4; dir++) {
                        int nx = i + topdx[dir];
                        int ny = j + dy[dir];
                        if (nx<1 || nx>R || ny<1 || ny>C || map[nx][ny]==-1) continue;
                        cnt++;
                    }
                    map[i][j] -= (dust[i][j]/5 * cnt);
                }
            }
        }
    }

    private static void updateDust() {
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                dust[i][j] = map[i][j];
            }
        }
    }

    private static void recursion() {
        // 상단 공기청정기 동작 (반시계방향)
        int r = airR-1;
        int c = 1;
        int dir = 0;

        while (true) {
            int nr = r + topdx[dir];
            int nc = c + dy[dir];

            // 경계 조건: 반시계 방향이므로 위, 왼쪽, 오른쪽, 아래 방향에서 이동 제한
            if (nr > airR || nc > C || nr < 1) {
                dir++;  // 방향 전환
                continue;
            }

            // 공기청정기 위치라면 동작 종료
            if (map[nr][nc] == -1) {
                map[r][c] = 0;
                break;
            }

            // 먼지 이동
            map[r][c] = map[nr][nc];
            r = nr;
            c = nc;
        }

        // 하단 공기청정기 동작 (시계방향)
        r = airR+2;
        c = 1;
        dir = 0;

        while (true) {
            int nr = r + botdx[dir];
            int nc = c + dy[dir];

            // 경계 조건: 시계 방향이므로 아래, 오른쪽, 왼쪽, 위쪽 방향에서 이동 제한
            if ( nr >R || nc > C || nr<airR+1) {
                dir++;  // 방향 전환
                continue;
            }

            // 공기청정기 위치라면 동작 종료
            if (map[nr][nc] == -1) {
                map[r][c] = 0;
                break;
            }

            // 먼지 이동
            map[r][c] = map[nr][nc];
            r = nr;
            c = nc;
        }

    }


}