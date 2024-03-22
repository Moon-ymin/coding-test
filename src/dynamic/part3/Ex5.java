package dynamic.part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5 {
    // 못생긴 수
    static int n;
    static ArrayList<Integer> ugly = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 2, 3, 5 배 하는 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        ugly.add(1);
        for (int i = 1; i < n; i++) {
            ugly.add( Math.min(next2, Math.min(next3, next5)) );
            if (ugly.get(i) == next2) {
                i2 += 1;
                next2 = ugly.get(i2) * 2;
            }
            if (ugly.get(i) == next3) {
                i3 += 1;
                next3 = ugly.get(i3) * 3;
            }
            if (ugly.get(i) == next5) {
                i5 += 1;
                next5 = ugly.get(i5) * 5;
            }
        }
        System.out.println(ugly.get(n-1));
    }
}
