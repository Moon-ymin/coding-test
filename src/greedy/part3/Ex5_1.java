package greedy.part3;

import java.util.Scanner;

public class Ex5_1 {
    // 볼링공 고르기 - 책 풀이
    public static int N, M;
    public static int[] arr = new int[11]; // 1~10까지의 무게를 담을 수 있는 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr[x] += 1;
        }

        int result = 0;

        // 1부터 m까지의 각 무게에 대하여 정리
        for (int i = 1; i <=M ; i++) {
            N -= arr[i]; // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
            result += arr[i] * N; // B가 선택하는 경우의 수와 곱헤주기
        }
        System.out.println(result);
    }
}
