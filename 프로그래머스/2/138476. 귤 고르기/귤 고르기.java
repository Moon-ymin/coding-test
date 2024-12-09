import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // 1. 크기 별 갯수 카운팅
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int size : tangerine){
            cnts.put(size, cnts.getOrDefault(size, 0) + 1);
        }
        
        // 2. 크기 별 내림차순 정렬
        List<Integer> cntList = new ArrayList<>(cnts.values());
        cntList.sort(Collections.reverseOrder());
        
        // 3. k에서 차감해 최소 귤 크기 개수 카운팅
        for(int count : cntList) {
            k -= count;
            answer++;
            if (k <= 0) break; // 필요한 개수를 만족하면 멈춤
        }
        
        return answer;
    }
}