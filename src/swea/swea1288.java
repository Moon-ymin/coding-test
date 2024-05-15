// 1번 코드
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
       

        for (int testcase = 1; testcase <= T ; testcase++) {
            int N = sc.nextInt();
            sc.nextLine();
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


// 2번 코드

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

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


// 3번 코드 
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


// 있을 때 1번 코드만 메모리 오류가 떴고, 2번 3번은 메모리 오류 안떴어 왜그런거야?
