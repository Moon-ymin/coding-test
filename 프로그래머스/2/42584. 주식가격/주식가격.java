class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            int time = 0;
            for(int j=i+1; j<n; j++){
                time++;
                if (prices[i] > prices[j]) { // 가격이 떨어졌다면 반복 종료하기
                    break;
                }
            }
            answer[i] = time;
        }
        return answer;
    }
}