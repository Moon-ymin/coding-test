import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Ball {
		int x, y; 

		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int map[][], maxScore, N;
	static ArrayList<Ball>[] wormHoles;
	static List<int[]> starts = new ArrayList<>(); // 값이 0으로 시작 가능한 곳

	static int[][] dirChange = {{0, 0, 0, 0}, {1, 2, 3, 0}, {1, 3, 0 ,2}, {3, 0, 1, 2}, {2, 0, 3, 1}, {1, 0, 3, 2}};
    static int[] moveR = {0, 0, -1, 1};
    static int[] moveC = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			wormHoles = new ArrayList[5]; // 웜홀들 저장 : 6~10 번 각각 좌표들 저장 2개씩 
			
			for(int i=0; i<5; i++) {
                wormHoles[i] = new ArrayList<>();
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] >= 6) {
                    	wormHoles[map[i][j]-6].add(new Ball(i, j));
                    }
                }
            }

            maxScore = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]!=0)
                        continue;
                    for(int dir=0; dir<4; dir++) {

                        int score = put(i, j, dir);
                        if(score > maxScore)
                        	maxScore = score;
                    }
                }
            }

            System.out.println("#"+t+" "+maxScore);
		}
		
	}
	
	static int put(int x, int y, int dir) {
	    int score = 0;
	    int moveX = x, moveY = y;   // 공의 현재 위치
	    int move = 0;               // 이동한 횟수

	    while (true) {
	        // 시작 위치로 돌아오면 게임 종료
	        if (moveX == x && moveY == y && move != 0) 
	            break;

	        // 블랙홀에 들어가면 게임 종료
	        if (map[moveX][moveY] == -1)
	            break;

	        // 이동
	        moveX += moveR[dir];
	        moveY += moveC[dir];
	        move++;

	        // 벽에 부딪힘
	        if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) {
	            moveX -= moveR[dir];
	            moveY -= moveC[dir];

	            // 방향 반전
	            if (dir == 0) dir = 1;
	            else if (dir == 1) dir = 0;
	            else if (dir == 2) dir = 3;
	            else if (dir == 3) dir = 2;

	            score++;
	        }

	        // 블록에 부딪힘
	        if (map[moveX][moveY] >= 1 && map[moveX][moveY] <= 5) {
	            int block = map[moveX][moveY];

	            // 방향을 변경
	            dir = dirChange[block][dir];
	            score++;
	            continue;
	        }

	        // 웜홀에 빠짐
	        if (map[moveX][moveY] >= 6) {
	            int wormholeNum = map[moveX][moveY] - 6;
	            int wx = wormHoles[wormholeNum].get(0).x;
	            int wy = wormHoles[wormholeNum].get(0).y;
	            
	            int wx2 = wormHoles[wormholeNum].get(1).x;
	            int wy2 = wormHoles[wormholeNum].get(1).y;
	            

	            // 현재 위치가 웜홀1이면 웜홀2로 이동, 웜홀2이면 웜홀1로 이동
	            if (moveX == wx && moveY == wy) {
	                moveX = wx2;
	                moveY = wy2;
	            } else {
	                moveX = wx;
	                moveY = wy;
	            }
	        }
	    }

	    return score;
	}

}