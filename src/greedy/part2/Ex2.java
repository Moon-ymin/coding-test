package greedy.part2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    // 동빈이의 큰 수의 법칙
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // 2. N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int counter = 0;
        int result = 0;
        for(int i=0; i<m; i++) {
            if ( counter < k ){
                result += arr[n-1];
                counter++;
            } else {
                result += arr[n-2];
                counter = 0;
            }
        }
        System.out.println(result);

    }
}
