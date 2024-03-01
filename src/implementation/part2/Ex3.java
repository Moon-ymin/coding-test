package implementation.part2;

import java.util.Scanner;

public class Ex3 {
    // 게임 개발

    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int dir; // 게임 캐릭터가 바라보는 방향

    static void turnLeft() { // 왼쪽 방향으로 회전
        dir -= 1;
        if (dir == -1) {
            dir = 3;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       // 맵 생성
        int M = sc.nextInt();
        int[][] map= new int[N][M];
        int[][] visit = new int[N][M];

        int x = sc.nextInt();       // 현재 위치, 방향
        int y = sc.nextInt();
        dir = sc.nextInt();
        visit[x][y] = 1;
        int visit_cnt = 1; // 결과 - 방문한 칸
        int cnt = 0;    // 네 방향 확인

        for(int i=0; i<N; i++) {    // 맵 채우기
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true){
            turnLeft(); // 1. 왼쪽 회전
            int nextx = x + dx[dir];      // 다음 위치
            int nexty = y + dy[dir];

            // 2. 육지(0)이고, 가본 적 없는 곳
            if ( map[nextx][nexty] == 0 && visit[nextx][nexty] == 0) {
                x = nextx;  // 이동
                y = nexty;
                visit[x][y] = 1; // 가봤다고 표시
                visit_cnt += 1;
                cnt = 0;
                continue;
            } else {
                cnt += 1; // 회전했는데, 가보지 않은 칸이 없을 때
            }

            // 3. 네 번 다 회전함
            if ( cnt == 4 ){
                // 방향 유지, 뒤로 이동
                nextx = x - dx[dir];
                nexty = y - dy[dir];

                if (map[nextx][nexty] == 0){
                    // 가능하다면 한 칸 뒤로
                    x = nextx; y = nexty; cnt = 0;
                } else {
                  // 한 칸 뒤로 못 가면 움직임 멈춤
                  break;
                }
            }

        }

        System.out.println(visit_cnt);
    }


}
