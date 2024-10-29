import java.util.*;

class Solution {
    public String target;
    public int answer = 0; // 타겟 단어 만드는데까지 걸린 순서
    
    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }
    private boolean dfs(String curr){
    
        if (!curr.equals("")){
            answer++;
            
            if (curr.equals(target)){
                return true;
            }    
        }
        
        
        if (curr.length() == 5) return false;
        
        for(char c : "AEIOU".toCharArray()){
            if (dfs(curr+c)) return true;
        }
        return false;
    }
}