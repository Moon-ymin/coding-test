import java.util.*;

class Solution {
    int answer;
    boolean[] isSelected;
    String[] nums;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        nums = numbers.split("");
        answer = 0;
        isSelected = new boolean[nums.length];
        
        // 모든 가능한 순열을 생성
        for (int i = 1; i <= nums.length; i++) {
            dfs("", i); // 순열의 길이를 늘려가며 탐색
        }
        
        // Set에 저장된 각 숫자에 대해 소수인지 체크
        for (int num : set) {
            if (check(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 순열을 생성하는 dfs 함수
    void dfs(String current, int length) {
        if (current.length() == length) {
            int num = Integer.parseInt(current);
            set.add(num);  // 중복 제거를 위해 Set에 추가
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                dfs(current + nums[i], length);  // 선택한 숫자를 추가
                isSelected[i] = false;
            }
        }
    }
    
    // 소수인지 체크하는 함수
    boolean check(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
