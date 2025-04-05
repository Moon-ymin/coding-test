import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 1. 보석 종류 파악 - Set
        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        // 2. 슬라이딩 윈도우로 보석별 개수를 저장할 Map
        Map<String, Integer> map = new HashMap<>();
        
        // 3. 투 포인터
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int answerStart = 0, answerEnd = 0;
        
        // 4. 슬라이딩 윈도우 시작
        while(true){
            // 지금 구간에서 보석 다 안모음
            if (map.size() < kinds.size()){
                if (end == gems.length) break;
                map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
                end++;
            } else { // 보석 종류 다 모음
                if (end-start<minLen){ // 구간 길이 더 짧은 경우
                    minLen = end-start;
                    answerStart = start+1;
                    answerEnd = end;
                }
                map.put(gems[start], map.get(gems[start])-1);
            
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        
        return new int[]{answerStart, answerEnd};
    }
}