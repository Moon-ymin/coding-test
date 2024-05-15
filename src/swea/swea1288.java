import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testcase = 1; testcase <= T ; testcase++) {
            int N = sc.nextInt();
            Set<Integer> nums = new TreeSet<>();

            int mul = 1;
            while(nums.size() < 10) {
                String[] num = String.valueOf(N * mul++).split("");
                for (int i = 0; i < num.length; i++) {
                    nums.add(Integer.parseInt(num[i]));
                }
            }
            System.out.println("#" + testcase + " " + (N * --mul));
        }

    }
}
