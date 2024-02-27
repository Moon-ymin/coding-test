package greedy.part2;

import java.util.Scanner;

public class Ex1 {
    /* 거스름돈
    당신은 음식점의 계산을 도와주는 점원이다.카운터에는 거스름돈으로 사용할
    500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다.
    손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라.
    단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int coin = 0;
        int[] changes = {500, 100, 50, 10};

        for (int change : changes) {
            coin += N / change;
            N %= change;
        }
        System.out.println("최소 동전의 개수 : " + coin);

    }
}
