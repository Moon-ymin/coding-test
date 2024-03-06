package sorting.part2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex11 {
    // 두 배열의 원소 교체
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if ( a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else break;

        }
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        System.out.println(sum);
    }
}
