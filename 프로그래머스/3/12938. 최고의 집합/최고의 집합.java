// 1. 원소의 합이 S
// 2. 원소의 곱 이 최대 -> 최고의 집합
// 수들을 가장 고르게 분배했을 때 최대
// s / n = 1, s%n = 3으로 => 몫이 1 + 1개, 몫+1 이 3개
class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        int share = 0, left = 0;
        
        share = s / n;
        if (share==0) {
            answer = new int[]{-1};
            return answer;
        } 
        answer = new int[n];
        left = s % n;
        for(int i=0; i<n-left; i++){
            answer[i] = share;
        }
        for(int i=n-left; i<n; i++){
            answer[i] = share+1;
        }
        return answer;
    }
}