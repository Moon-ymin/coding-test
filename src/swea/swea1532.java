import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            int m = sc.nextInt() - 1;

            int std = e;

            // 세 정수 S, E, M을 입력받았을 때, E가 가장 작은 수이므로 기준으로 잡는다.
            // e를 24씩 증가 시키면서 365로 나눈 나머지 값이 s와 일치하고 29로 나눈 나머지 값이 m이랑 일치할 때의 값을 찾는다.
            while(true) {
                if(std % 365 == s && std % 29 == m) {
                    System.out.println("#" + t + " " + (std+1));
                    break;
                }
                std += 24;
            }
        }
    }
}
