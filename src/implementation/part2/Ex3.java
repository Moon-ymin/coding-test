package implementation.part2;

import java.util.Scanner;

public class Ex3 {
    // 게임 개발
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    static int turnLeft( int dir ) { // 왼쪽 방향
        dir -= 1;
        if (dir == -1) {
            dir = 3;
        }
        return dir;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // 맵 생성
        int M = sc.nextInt();
        int[][] map= new int[N][M];
        int[][] visited = new int[N][M];

        int x = sc.nextInt();       // 현재 위치, 방향
        int y = sc.nextInt();
        int dir = sc.nextInt();
        visited[x][y] = 1;

        for(int i=0; i<N; i++) {    // 맵 채우기
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int fail = 0;
        while (true){
            dir = turnLeft(dir); // 왼쪽 회전
            fail++;
            int nextx = 0, nexty = 0;
            nextx = x + dx[dir];      // 다음 위치
            nexty = y + dy[dir];

            // 육지(0)이고, 가본 적 없는 곳
            if ( map[nextx][nexty] == 0 && visited[nextx][nexty] == 0) {
                x = nextx;  // 이동
                y = nexty;
                visited[x][y] = 1; // 가봤다고 표시
                cnt++;
                fail = 0;
            }
            if ( fail == 4 ){   // 네 번 다 회전해본거임
                // 방향 유지, 뒤로 이동
                nextx = x - dx[dir];
                nexty = y - dy[dir];

                if (map[nextx][nexty] == 1) break; // 바다일 경우
                else x = nextx; y = nexty; visited[x][y] = 1; fail = 0;
            }

        }

        System.out.println(cnt);
    }


}
