import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int testcase = 1; testcase <= T ; testcase++) {
            int N = sc.nextInt();
            sc.nextLine();
            int[][] map = new int[N][N];

            // map 생성
            for (int i = 0; i < N; i++) {
                String[] nums = sc.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(nums[j]);
                }
            }

            int[][] rotate90 = rotate(map, 90);
            int[][] rotate180 = rotate(map, 180);
            int[][] rotate270 = rotate(map, 270);

            System.out.println("#"+testcase);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(rotate90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(rotate180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(rotate270[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static int[][] rotate(int[][] map, int rotate){
        int N = map.length;
        int[][] result = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switch (rotate) {
                    case 90:
                        result[i][j] = map[N-1-j][i];
                        break;
                    case 180:
                        result[i][j] = map[N-1-i][N-1-j];
                        break;
                    case 270:
                        result[i][j] = map[j][N-1-i];
                        break;
                }
            }
        }

        return result;
    }
}
