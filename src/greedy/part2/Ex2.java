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

        // 반복되는 수열, m의 크기가 커졌을 경우 시간 초과를 막기 위해 좀 더 효율적인 방법
        int count = (m / (k+1)) * k;// 가장 큰 수가 더해지는 횟수
        count += m % (k+1);
        int total = 0;
        total += count * arr[n-1];  // 가장 큰 수 더하기
        total += (m-count) * arr[n-2];  // 중복되지 않게 두 번째로 큰 수 더하기
        System.out.println(total);

    }
}
