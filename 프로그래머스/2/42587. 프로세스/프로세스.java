import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐에 (문서 중요도, 초기 인덱스) 쌍으로 저장하기
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }

        int printOrder = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            boolean isHigher = false;

            // 현재 문서보다 중요도가 높은 문서 있는지 확인하기
            for (int[] doc : q){
                if (doc[0] > cur[0]) {
                    isHigher = true;
                    break;
                }
            }

            if (isHigher) {
                // 현재 문서보다 중요도 높은 문서 있으면 뒤로 보냄
                q.offer(cur);
            } else {
                // 현재 문서 인쇄하기
                printOrder++;
                if (cur[1] == location) return printOrder;
            }
        }

        return -1;
    }
}