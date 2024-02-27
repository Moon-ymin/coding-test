package greedy.part3;

import java.util.Scanner;

public class Ex2 {
    // 곱하기 혹은 더하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] nums = str.split("");

        int result = Integer.parseInt( nums[0] );

        for(int i=1; i<nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if ( result == 0 || num == 0 ) {
                result += num ;
            } else {
                result *= num;
            }
        }
        System.out.println(result);
    }
}
