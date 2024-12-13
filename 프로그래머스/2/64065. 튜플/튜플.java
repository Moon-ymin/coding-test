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
        Set<Integer> seen = new HashSet<>();
        for(String word : words){
            String[] ws = word.split(",");
            for(String w : ws){
                int num = Integer.parseInt(w);
                // // List에 숫자 없으면 추가
                // if (!answer.contains(num)) answer.add(num);
                // set에 없는 애만 추가
                if (seen.add(num)) answer.add(num);
            }
        }
        
        // 4. set을 배열로 변환해서 출력
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/* 3에서 중복있는지 확인하는 과정 
    if(!answer.contains(num)) -> 순차탐색 O(n) : n과 함께 너무 커짐

    HashSet의 add 메서드는 중복될 때 false를 반환
    -> O(1) 시간복잡도
    */
