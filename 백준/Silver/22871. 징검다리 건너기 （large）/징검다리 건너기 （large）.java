import java.util.Scanner;

public class Main {
    static int N;
    static long[] stones;
    static Long[] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stones = new long[N];
        dp = new Long[N];
        
        for (int i = 0; i < N; i++) {
            stones[i] = sc.nextInt();
        }
        
        System.out.println(jump(0));
    }
    
    private static long jump(int curr) {
        if (curr == N-1) return 0;
        if (dp[curr] != null) return dp[curr];
        
        dp[curr] = Long.MAX_VALUE;
        
        for (int next = curr + 1; next < N; next++) {
            long power = (next - curr) * (1L + Math.abs(stones[next] - stones[curr]));
            dp[curr] = Math.min(dp[curr], Math.max(power, jump(next)));
        }
        
        return dp[curr];
    }
}