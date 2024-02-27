package greedy.part2;

import java.util.Scanner;

public class Ex3 {
    // 숫자 카드 게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 카드 선언
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i=0; i<n; i++){
            // 현재 행에서 가장 작은 수 찾기
            int min_val = 10001;
            for (int j=0; j<m; j++) {
                int x = sc.nextInt();
                min_val = Math.min(min_val, x);
            }
            // 가장 작은 수들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_val);
        }
        System.out.println(result);

    }
}
