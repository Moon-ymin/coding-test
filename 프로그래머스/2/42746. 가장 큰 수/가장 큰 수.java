import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        
        // 1. int 형 배열 String으로 변환
        for(int i=0; i<numbers.length; i++){
            strs[i] = String.valueOf(numbers[i]);
        }
        // 2. 배열 정렬 
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        // 3. 모든 숫자가 0인 경우 처리
        if (strs[0].equals("0")) return "0";
        
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s);
        }
        
        return result.toString();
    }
}