class Solution {
    int solution(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        
        // DP 계산 
        for(int i=1; i<rows; i++){
            // 이전 행에서 최댓값과 두 번째로 큰 값 계산
            int max1= -1, max2 = -1;
            for(int j=0; j<cols; j++){
                if (land[i-1][j] > max1){
                    max2 = max1;
                    max1 = land[i-1][j];
                } else if (land[i-1][j] > max2){
                    max2 = land[i-1][j];
                }
            }
            
            for (int j=0; j<cols; j++){
                if (land[i-1][j] == max1){
                    land[i][j] += max2;
                } else {
                    land[i][j] += max1;
                }
            }
        }
        
        // 마지막 행에서 최댓값 반환
        int answer = 0;
        for(int j=0; j<cols; j++){
            answer = Math.max(answer, land[rows-1][j]);
        }
        return answer;
    }
}

