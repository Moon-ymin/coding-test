import java.util.*;

public class swea1989 {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int testcase = 1; testcase <= T; testcase++) {
            String before = sc.nextLine();
            StringBuilder str = new StringBuilder(before).reverse();
            String after = str.toString();
            if(before.equals(after)) System.out.println("#"+testcase+" 1");
            else System.out.println("#"+testcase+" 0");

        }
        // 문자열을 StringBuilder 또는 StringBuffer를 사용하여 역순으로 변환:
    }
}
