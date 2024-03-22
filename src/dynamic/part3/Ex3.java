package dynamic.part3;

import java.util.Scanner;

public class Ex3 {
    // 퇴사
    static int n;
    static int[] t;   // 시간
    static int[] p;   // 금액
    static int[] dp;  // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
    static int maxValue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n];
        p = new int[n];
        dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        // 배열을 뒤에서부터 거꾸로 확인
        for (int i = n-1; i >= 0; i--) {
            int time = t[i] + i;
            // 상담이 기간 안에 끝나는 경우
            if (time <= n) {
                // 점화식에 맞게 현재까지 최고 이익 계산
                dp[i] = Math.max(p[i] + dp[time], maxValue);
                maxValue = dp[i];
            } // 상담이 기간을 벗어나는 경우
            else dp[i] = maxValue;
        }
        System.out.println(maxValue);
    }

}
