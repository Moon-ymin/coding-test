package greedy.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex4 {
    // 만들 수 없는 금액
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> coins = new ArrayList<>();
        String money = sc.next();

        for (int i=0; i<n; i++) {
            coins.add(  money.charAt(i) - '0' );
        }

        Collections.sort(coins);

        int target = 1;
        for (int coin : coins){
            if ( coin > target ){
                break;
            } else {
                target += coin;
            }
        }
        System.out.println(target);
    }
}

/* 기억하기
char to int : char - '0' 아스키 코드 이용
*/
