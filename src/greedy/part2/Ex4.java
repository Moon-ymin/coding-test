package greedy.part2;

import java.util.Scanner;

public class Ex4 {
    // 1이 될 때까지
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        while (n!=1) {
            if (n % k ==0) {
                n /= k;
            } else {
                n -= 1;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    /* 다른 방식
    1. n에서 일일히 1을 뺄때마다 k로 나누어지는지 확인하는 것이 비효율적
    2. n이 k로 나누어 떨어지는 수(n이 k의 배수가 되는 수)를 구해서 한 번에 빼준다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // n이 k로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n/k) * k;
            result += (n-target);
            n=target;

            // n이 k보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n<k) break;
            // k로 나누기
            result += 1;
            n/=k;
        }
        // 마지막으로 남은 수에 대해 1씩 빼기
        result += (n-1);
        System.out.println(result);
    }
     */
}
