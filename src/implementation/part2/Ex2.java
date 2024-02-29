package implementation.part2;

import java.util.Scanner;

public class Ex2 {
    // 왕실의 나이트
    static int[][] next = {
            {-2,-1},{-1,-2},{-2,1},{-1,2},
            {1,-2},{2,-1},{1,2},{2,1}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String position = sc.nextLine();
        int row = position.charAt(1) - '0';
        int col = position.charAt(0) - 'a' + 1; // 'a' - 'a' + 1

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nextrow = row + next[i][0];
            int nextcol = col + next[i][1];
            if ( nextrow >= 1 && nextrow <= 8
            && nextcol >= 1 && nextcol <= 8) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
