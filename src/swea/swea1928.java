import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int testcase = 1; testcase <= T ; testcase++) {
            String words = sc.nextLine(); // TGlmZSB ...
            int[] numbers = new int[words.length()];

            // 1. 표1을 보고 입력받은 문자들을 각각 대응하는 숫자로 변경한다.
            // 대문자, 소문자, 숫자, + 와 / 있으므로, 모두 대응하도록 반영할 것
            for (int i = 0; i < words.length(); i++) {
                if (words.charAt(i) <= 'Z' && words.charAt(i) >= 'A'){ // 대문자일 경우
                    numbers[i] = words.charAt(i) - 'A';
                } else if (words.charAt(i) >= 'a'){     // 소문자일 경우
                    numbers[i] = words.charAt(i) - 'a' + 26;
                } else if ('0' <= words.charAt(i) && words.charAt(i) <= '9') {  // 숫자일 경우
                    numbers[i] = words.charAt(i) - '0' + 52;
                } else if ( '+' == words.charAt(i) ){   // + 일 경우
                    numbers[i] = 62;
                } else {    // / 일경우
                    numbers[i] = 63;
                }
            }

            // 2. 각 숫자들을 6자리 이진수로 표현하고, 이 이진수들을 한 줄로 쭉 이어 붙인다.
            // Integer.toBinaryString()  :  int to String 형태 2진수로 변환
            String binary = "";
            for (int i = 0; i < numbers.length; i++) {
                String binaryString = Integer.toBinaryString(numbers[i]);   // 2진수 문자열로 만듦
                if (binaryString.length() < 6) { // 6자리로 바꿈
                    String plus = "";
                    for (int j = 0; j < 6-binaryString.length(); j++) {
                        plus += "0";
                    }
                    binary += (plus + binaryString);
                } else {
                    binary += binaryString;
                }
            }
            // System.out.println(binary.length());

            // 3. 한 줄로 쭉 이어붙인 이진수들을 8자리씩 끊어서 십진수로 바꾼다.
            // Integer.parseInt(2진수 문자열, 변환할 진법)  :  2진수문자열을 10진수로 바꾸기
            List<Integer> toTen = new ArrayList<>();
            for (int i = 0; i < binary.length(); i+=8) {
                String oct = "";
                for (int j = i; j < i+8; j++) {
                    oct += String.valueOf(binary.charAt(j));
                }
                toTen.add( Integer.parseInt(oct,2)); // 십진수로 바꾼 숫자들 toTen 에 담기
            }
            System.out.println(T);
          
            // 4. 각각의 십진수를 아스키 코드로 변환한다.
            // .intValue() : Integer 형 변수를 int 형 변수로 변환
            // (char) : int형 변수를 아스키 코드 값으로 변환 
            String result = "";
            for (int i = 0; i < toTen.size(); i++) {
                result += String.valueOf( (char) toTen.get(i).intValue() );
            }
            System.out.println("#" + testcase + " " + result);

        }

    }
}
