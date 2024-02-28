package greedy.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex4_1 {
    // 만들 수 없는 금액 - Scanner 말고 BufferReader 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );
        String[] s = br.readLine().split("");
        int[] coins = new int[n];

        int target=1;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(coins);

        for (int coin : coins) {
            if (target < coin) break;
            target += coin;
        }
        System.out.println(target);
    }
}
