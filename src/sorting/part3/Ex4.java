package sorting.part3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }
        long result = 0;
        while( pq.size() > 1) {
            long c1 = pq.poll();
            long c2 = pq.poll();

            result += c1 + c2;
            pq.offer(c1 + c2);
        }
        System.out.println(result);

    }
// 우선순위 큐 이용

}
