class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int r1=0; r1<arr1.length; r1++){
            for(int c2=0; c2<arr2[0].length; c2++){
                int num = 0;
                for(int r2=0; r2<arr2.length; r2++){
                    num += (arr1[r1][r2] * arr2[r2][c2]);
                }
                answer[r1][c2] = num;
            }
        }
        return answer;
    }
}