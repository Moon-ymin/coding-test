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
}
