import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        // 배열 사이즈
        long size = right-left+1;
        // 정답 배열
        int[] answer = new int[(int)size];
        // 정답 인덱스
        int idx=0;
        // left ~ right 까지 반복
        for(long i=left; i<=right; i++){
            // 열, 행
            // ex) i=2, n=3 -> 1행 3열
            int row = (int)(i/n)+1;
            int col = (int)(i%n)+1;

            // 행이 열보다 작으면
            // ex) 1행 3열, col = 3
            if(row<col){
                answer[idx++] = col;    
            // 행이 열보다 크면
            // ex) 3행 1열, row = 3
            }else{
                answer[idx++] = row;    
            }
            
        }
       
        return answer;
    }
}