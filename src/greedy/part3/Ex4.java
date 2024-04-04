package greedy.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex4 {
    // 만들 수 없는 금액
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int target = 1;
        for (int i = 0; i < n; i++) {
            // 만들 수 없는 금액을 찾았을 때 반복 종료
            if (target < arrayList.get(i)) break;
            target += arrayList.get(i);
        }

        System.out.println(target);
    }
}

/* 기억하기
char to int : char - '0' 아스키 코드 이용
*/
