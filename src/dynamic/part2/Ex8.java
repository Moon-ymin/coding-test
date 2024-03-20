package dynamic.part2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex8 {
    // 효율적인 화폐 구성
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }

        // DP 테이블 초기화
        int[] d = new int[m+1];
        Arrays.fill(d, 10001);

        // 다이나믹 프로그래밍 진행
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = money[i] ; j <= m; j++) {
                // (i-k)원을 만드는 방법이 존재하는 경우
                if (d[j-money[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j-money[i]] + 1);
                }
            }
        }
        if(d[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }


    }
}
