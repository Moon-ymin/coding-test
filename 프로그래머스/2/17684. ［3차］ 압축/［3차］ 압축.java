import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 리스트 answer
        List<Integer> answer = new ArrayList<>();
        // Map으로 사전 초기화 A~Z : words
        Map<String, Integer> words = new HashMap<>();
        for(char c='A'; c<='Z'; c++){
            words.put(String.valueOf(c), c-'A'+1);
        }
        
        // msg에서 words에 있는 가장 긴 문자열 찾기
        int i = 0;
        int dictIndex = 27;
        while(i<msg.length()){
            String w = ""+msg.charAt(i);
            int index = i;
            
            // 가장 긴 문자열 w 찾기
            while(index+1<msg.length() && words.containsKey(w+msg.charAt(index+1))){
                w += msg.charAt(index+1);
                index++;
            }
            // 해당 인덱스 answer에 추가
            answer.add(words.get(w));
            // words에 w+c 를 추가
            if(index+1 < msg.length()){
                words.put(w + msg.charAt(index+1), dictIndex++);   
            }
            
            // i를 다음 탐색 위치로 이동
            i = index + 1;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray(); // answer을 배열로 바꿔서 출력
    }
}