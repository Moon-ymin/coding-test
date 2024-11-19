import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        // PriorityQueue로 최솟값과 최댓값을 추적
        Queue<Integer> pq = new PriorityQueue<Integer>();
        Queue<Integer> rpq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            switch (temp[0]) {
                case "I":
                    int value = Integer.parseInt(temp[1]);
                    pq.add(value); 
                    rpq.add(value);
                    break;
                case "D":
                    if (pq.size() > 0) {
                        if (Integer.parseInt(temp[1]) == 1) {
                            
                            int max = rpq.poll();
                            pq.remove(max);
                        } else {
                            int min = pq.poll();
                            rpq.remove(min);
                        }
                    }
                    break;
            }
        }

        if (pq.size() > 0 && rpq.size() > 0) {
            answer[0] = rpq.poll(); 
            answer[1] = pq.poll(); 
        }

        System.out.println(answer[0] + ":" + answer[1]);

        return answer;
    }
}
