import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class solution_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 연산의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 2. 연산에 대한 정보 정수 x (자연수 : x 추가, 0 : 배열에서 가장 큰 값 출력, 제거)
        // 추가, 큰 값 출력 -> 우선순위 큐 사용, 역순으로 정렬 (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            Integer num = Integer.parseInt(br.readLine());
            if (num == 0){
                if (pq.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(pq.peek());
                    pq.poll();
                }
            } else {
                pq.add(num);
            }

        }

    }
}
