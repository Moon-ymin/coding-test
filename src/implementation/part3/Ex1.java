package implementation.part3;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        String[] nums = N.split("");
        int left = 0;
        int right = 0;

        for (int i=0; i<nums.length; i++){
            if( i < nums.length / 2 ) {
                left += nums[i].charAt(0) - '0';
            } else {
                right += nums[i].charAt(0) - '0';
            }
        }
        String answer = ( left == right ? "LUCKY" : "READY" );
        System.out.println(answer);
    }
}
