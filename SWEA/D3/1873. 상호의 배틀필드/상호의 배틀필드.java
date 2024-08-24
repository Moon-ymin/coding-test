import java.util.Scanner;

public class Solution{
    static String map[][];
    static int H, W, N, tX, tY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 1. 테스트 케이스
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {

            // 2. 맵의 높이 H, 너비 W
            H = sc.nextInt();
            W = sc.nextInt();
            map = new String[H][W];

            // 3. 맵 채우기
            for (int i = 0; i < H; i++) {
                map[i] = sc.next().split("");
                for (int j = 0; j < W; j++) {
                    if ("^v<>".contains(map[i][j])) {
                        tX = i; tY = j;
                    }
                }
            }

            // 4. 사용자가 실행할 동작
            N = sc.nextInt();
            String commands = sc.next();
            for (int i = 0; i < N; i++) {
                char control = commands.charAt(i);
                switch (control) {
                    case 'U': moveTrain(-1, 0, "^"); break;
                    case 'D': moveTrain(1, 0, "v"); break;
                    case 'L': moveTrain(0, -1, "<"); break;
                    case 'R': moveTrain(0, 1, ">"); break;
                    case 'S': shoot(); break;
                }
            }

            sb.append("#"+t+" ");
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    // 전차가 이동할 수 있는지 확인
    private static boolean isAvailable(int x, int y){
        return x >= 0 && y >= 0 && x < H && y < W && map[x][y].equals(".");
    }
    // 전차가 이동할 때
    private static void moveTrain(int dx, int dy, String dir) {
        int nx = tX + dx;
        int ny = tY + dy;
        map[tX][tY] = dir;
        if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny].equals(".")) {
            map[tX][tY] = ".";
            tX = nx; tY = ny;
            map[tX][tY] = dir;
        }
    }
    // 포탄 발사 로직
    private static void shoot() {
        String state = map[tX][tY];
        int dx = 0, dy = 0;

        switch (state) {
            case "v": dx = 1; break;
            case "^": dx = -1; break;
            case "<": dy = -1; break;
            case ">": dy = 1; break;
        }

        int nx = tX + dx;
        int ny = tY + dy;

        while (nx >= 0 && ny >= 0 && nx < H && ny < W) {
            if (map[nx][ny].equals("*")) {
                map[nx][ny] = ".";
                break;
            } else if (map[nx][ny].equals("#")) {
                break;
            }
            nx += dx;
            ny += dy;
        }
    }
}
