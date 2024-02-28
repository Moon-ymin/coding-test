package implementation.part2;

import java.util.Scanner;

public class Ex1 {
    // 상하좌우 L R U D
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;

    static boolean checkAvailable( int x, int y, int dx, int dy ){   // 공간을 벗어나는지 확인하는 메서드
        x += dx; y+= dy;
        return ( x >= 1 && x <= N ) && ( y >= 1 && y <= N);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        /* 입력값 받아오는 메서드
        1. next(), nextInt(), nextDouble() : 엔터키 입력하기 바로 전까지 입력
            사용자가 입력한 엔터는 버퍼에 남음
        2. 뒤에 공백(엔터)를 입력받는 nextLine()이 오는 경우 버퍼에 남은 엔터를 비워줘야 함
         */
        String[] plans = sc.nextLine().split(" ");

        int x = 1;
        int y = 1;
        for (String plan : plans){
            switch( plan ) {
                case "L":
                    if (checkAvailable(x, y, dx[0], dy[0])) {
                        x += dx[0]; y += dy[0];
                    }
                    break;
                case "R":
                    if (checkAvailable(x, y, dx[1], dy[1])) {
                        x += dx[1]; y += dy[1];
                    }
                    break;
                case "U":
                    if (checkAvailable(x, y, dx[2], dy[2])) {
                        x += dx[2]; y += dy[2];
                    }
                    break;
                case "D":
                    if (checkAvailable(x, y, dx[3], dy[3])) {
                        x += dx[3]; y += dy[3];
                    }
            }
        }
        System.out.println(x+", "+y);
    }
}
