import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.stream.Collectors;

public class swea2005 {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            System.out.println("#"+(test_case+1));
            int N = sc.nextInt();
            List<Integer> before = new ArrayList<>();
            List<Integer> after = new ArrayList<>();
            for (int n = 1; n <= N; n++) {
                if (n==1) {
                    before.add(1);    after = before;}
                else {
                    for (int i = 0; i < n; i++) {
                        if (i==0 || i==n-1) after.add(1);
                        else {
                            after.add(before.get(i-1)+before.get(i));
                        }
                    }
                }
                // List<Integer> 의 요소를 공백 포함해서 String 형태로 연결
                String answer = after.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));
                // List<Integer> 를 shallowCopy(얕은 복사) 하는 법
                // deepCopy(깊은 복사) 는 그냥 자체로 before = after 하면 됨
                before = new ArrayList<>(after);
                after.clear();
                System.out.println(answer);
            }

        }

    }
}
