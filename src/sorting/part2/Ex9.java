package sorting.part2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex9 {
    // 위에서 아래로
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];     // 주의!!! int가 아니라 Integer 사용!

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 기본 정렬 라이브러리 이용
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
