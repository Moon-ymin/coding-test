package implementation.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        int num = 0;
        String letter = "";
        for (String s : str){
            if ( s.charAt(0) >= 65){ // 문자면
                letter += s;
            } else { // 숫자면
                num += s.charAt(0) - '0';
            }
        }
        char[] chletter = letter.toCharArray();
        Arrays.sort(chletter);
        letter = String.valueOf(chletter);
        System.out.println( letter + Integer.toString(num) );
    }
}
/* 사용 함수
1. char array to String : String.valueOf(char array);
2. String to char array : str.toCharArray();
 */