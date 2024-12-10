import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 1. 원형이라서 마지막수 -> 처음수 경우 때문에 배열 길이 2배로
        int[] nums = new int[elements.length * 2];
        // 2. 배열에 숫자 넣기
        for(int i=0; i<nums.length; i++){
            nums[i] = (i<elements.length ? elements[i] : elements[i-elements.length]);
        }
        // 3. 합 중복 안되게 집합에 넣기
        Set<Integer> sums = new HashSet<>();
        
        
        for(int i=1; i<= elements.length; i++){ // 더해질 때 사용할 개수
            for(int j=0; j<elements.length; j++){
                sums.add(Arrays.stream(nums, j, j+i).sum());
            }
        }
        return sums.size();
    }
}