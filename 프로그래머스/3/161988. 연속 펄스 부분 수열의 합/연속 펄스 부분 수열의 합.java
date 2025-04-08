import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        // 펄스 값 구하기
        int[] pulse1 = new int[sequence.length];
        int[] pulse2 = new int[sequence.length];
        
        for(int i=0; i<sequence.length; i++){
            pulse1[i] = sequence[i] * (i%2==0 ? 1 : -1);
            pulse2[i] = sequence[i] * (i%2==0 ? -1 : 1);
        }
        long m1 = pulse1[0], s1 = pulse1[0];
        long m2 = pulse2[0], s2 = pulse2[0];
        // dp 진행
        for(int i=1; i<sequence.length; i++){
            s1 = Math.max(pulse1[i], s1+pulse1[i]);
            m1 = Math.max(m1, s1);
            
            s2 = Math.max(pulse2[i], s2+pulse2[i]);
            m2 = Math.max(m2, s2);
        }
        
        return Math.max(m1, m2);
    }
}