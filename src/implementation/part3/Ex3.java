package implementation.part3;

import java.util.Scanner;

public class Ex3 {
    // 문자열 압축
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int answer = s.length(); // 압축되지 않은 문자 그대로 길이

        // 자르는 길이 i, 문자열 길이의 절반까지 (절반 넘어가면 나눠질 수 없음)
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String piece = s.substring(0, i); // 자르는 길이만큼 문자열 추출
            String now = ""; // 현재 문자열
            int cnt = 1; // 압축된 길이
            StringBuilder sb = new StringBuilder(); // 압축된 문자열

            // 다음 문자열과 비교시작
            for (int start = i; start <= s.length(); start+=i) {
                // 남은 문자열이 자르는 단위보다 짧으면 남은 문자열 저장
                if(start + i >= s.length()){
                    now = s.substring(start, s.length());
                } else {
                    now = s.substring(start, start + i);
                }
                // 비교했는데 문자열이 같음
                if (now.equals(piece)) {
                    cnt++;
                } else if (cnt == 1){  // 다르면 비교대상 변경
                    sb.append(piece);
                    piece = now;
                } else {
                    sb.append(cnt).append(piece);
                    piece = now;
                    cnt = 1;
                }
            }
            // 자르고 마지막에 남는 문자열 추가
            if (i != piece.length()) sb.append(piece);
            answer = Math.min(answer, sb.toString().length());

        }
        System.out.println(answer);

    }

}
