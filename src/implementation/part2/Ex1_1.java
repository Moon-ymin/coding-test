package implementation.part2;

import java.util.Scanner;

// https://sangminlog.tistory.com/entry/DFS-BFS-algorithm
// https://doongjeol.tistory.com/87
public class Ex1_1 {
    // 시각
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s<60; s++) {
                    if ( Integer.toString(s).contains("3") ||
                            Integer.toString(m).contains("3") ||
                            Integer.toString(h).contains("3") ) { // 하나라도 3이 포함된다면
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    /* 다른 방식
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for (int h = 0; h <= n; h++) {  // 시
            for (int m = 0; m <= 59; m++) {     // 분
                for (int s = 0; s <= 59 ; s++) {    // 초
                    String time = h+"시"+m+"분"+s+"초";
                    if (time.contains("3")) result++;
                }
            }
        }
        System.out.println(result);

    }
     */
}
