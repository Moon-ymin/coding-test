package dynamic.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    // 금광 : 열 기준 행 탐색
    static int n, m;
    static int[][] arr;
    static int[][] dp;
    static int dx[] = {-1, 0, 1};   // 오른쪽 위, 오른쪽, 오른쪽 아래 움직임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();   // 테스트 케이스

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][m];    // 금광


            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = sc.nextInt();   // 금 입력 시키기
                }
            }
            dp = new int[n][m];
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i], -1);
            }
            for (int j = 0; j < n; j++) {
                dp[j][0] = arr[j][0];   // 열이 0인 dp에 arr 복사
            }

            for (int y = 1; y < m; y++) {  // 열을 기준으로 (1열부터)
                for (int x = 0; x < n; x++) {  // 행 체크
                    int max = 0;
                    for (int z = 0; z < 3; z++) {
                        int nx = x + dx[z];  // 오른쪽 위, 오른쪽, 오른쪽 아래(행 움직임)
                        if (nx >= 0 && nx < n) {  // 행 값이 범위 내라면
                            max = Math.max(max, dp[nx][y - 1]);  // dp[상, 중, 하][현재 열 - 1] 중 최대값을 찾음
                        }
                    }

                    dp[x][y] = max + arr[x][y];  // dp[x][y] = 한 열 앞에 있는 상, 중, 하 값 중 최댓값 + arr[x][y];
                }
            }
            int max = 0;
            for (int j = 0; j < n; j++) {  // 열이 m - 1인 dp값 중 최댓값을 찾음
                max = Math.max(max, dp[j][m - 1]);
            }

            System.out.println(max);


        }
    }
}
