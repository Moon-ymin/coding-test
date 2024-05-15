import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testcase = 1; testcase <= T; testcase++) {
            int K = sc.nextInt();
            sc.nextLine();
            String[] numbers = sc.nextLine().split(" ");
            int[] nums = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();

            System.out.printf("#%d %d\n", testcase, func(nums));
        }
    }
    public static int func(int[] nums){
        int sum = 0;
        if (nums.length == 1) return 0;
        else {
            int[] after = new int[nums.length / 2];
            for (int i = 0; i < nums.length - 1; i+=2) {
                int a = nums[i];
                int b = nums[i+1];
                sum += ( a>b ? a-b : b-a);
                after[i/2] = ( a>b ? a : b );
            }
            return sum + func(after);
        }
    }
}
