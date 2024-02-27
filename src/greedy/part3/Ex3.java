package greedy.part3;

import java.util.Scanner;

public class Ex3 {
    // 문자열 뒤집기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        String[] numbers = number.split("");

        int zeros = 0;
        int ones = 0;

        if (numbers[0].equals("0")) {
            ones++;
        } else {
            zeros++;
        }

        for(int i=0; i<number.length() - 1; i++) {
            if ( !numbers[i].equals(numbers[i+1])) { // 같은지 비교
                if ( numbers[i+1].equals("1")) {
                    ones++;
                } else { zeros++; }
            }
        }

        System.out.println( Math.min( zeros, ones ) );
    }
}
