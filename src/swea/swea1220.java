import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = 10; // 테스트 케이스 개수
        for (int testcase = 1; testcase <= T; testcase++) {
            int N = sc.nextInt();   // 크기
            int[][] table = new int[N][N];
            sc.nextLine();

            // 테이블 채우기
            for (int i = 0; i < N; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(s[j]);
                }
            }

            int sum = 0;
            // 열 별로 탐색 : 무조건 1-2 순서로 만났을 때 sum이 되더라
            for (int i = 0; i < N; i++) {
                int last = 0;
                for (int j = 0; j < N; j++) {
                    if (table[j][i] == 1) { // N극 이면
                        last = 1;
                    } else if (table[j][i] == 2){
                        if(last == 1) {
                            sum++;
                        }
                        last = 2;
                    }
                }
            }
            System.out.printf("#%d %d\n", testcase, sum);



        }
    }
}
