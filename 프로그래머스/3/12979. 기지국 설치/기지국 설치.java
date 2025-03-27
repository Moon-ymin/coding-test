class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int range = w*2 + 1;
        int start = 1;
        
        for(int station : stations){
            int left = station - w;
            int right = station + w;
            
            if (start < left) {
                int length = left - start;
                answer += (int) Math.ceil((double) length / range);
            }
            start = right + 1;
        }
        
        // 마지막 오른쪽에 남은 구간
        if (start <= n){
            int length = n - start + 1;
            answer += (int) Math.ceil((double) length / range);
        }
        return answer;
    }
}