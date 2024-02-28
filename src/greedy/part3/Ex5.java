package greedy.part3;

import java.util.Scanner;

public class Ex5 {
    // 볼링공 고르기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] balls = new int[N];
        for (int i = 0; i < N; i++) {
            balls[i] = sc.nextInt();
        }

        int result = 0;
        for (int i=0; i<N-1; i++){
            for (int j=i+1; j<N; j++) {
                if ( balls[i] != balls[j] ){
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}


