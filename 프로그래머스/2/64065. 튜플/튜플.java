import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. s의 처음과 끝 {{}} 삭제
        s = s.substring(2, s.length()-2);
        // 각 집합을 },{ 기준으로 분리함
        String[] words = s.split("\\},\\{");
        
        // 2. 문자열 길이 기준 오름차순 정렬
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        // 3. , 기준 split해서 set에 집어넣기
        List<Integer> answer = new ArrayList<>();
        for(String word : words){
            String[] ws = word.split(",");
            for(String w : ws){
                int num = Integer.parseInt(w);
                // List에 숫자 없으면 추가
                if (!answer.contains(num)) answer.add(num);
            }
        }
        
        // 4. set을 배열로 변환해서 출력
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}