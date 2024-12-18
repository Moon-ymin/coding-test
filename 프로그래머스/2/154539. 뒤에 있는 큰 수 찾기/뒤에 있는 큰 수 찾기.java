import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 1. numbers랑 길이 같은 빈 배열 
        int[] answer = new int[numbers.length];
        
        // 2. (인덱스, 값) 으로 스택에 쌓을거임
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        // 3. 스택의 최상단 값 < 현재 값 => 뒤에있는 큰 수, 하위 스택 원소들과도 비교 => 해당한다면 스택의 원소 pop하고 answer의 인덱스에 값 넣기
        for(int i=1; i<numbers.length; i++){
            while(!stack.empty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        // 4. 큰 수 없고(스택에 남아있는 경우) answer의 인덱스에 -1 넣기
        while(!stack.empty()){
            answer[stack.pop()] = -1;
        }
        
        
        return answer;
    }
}