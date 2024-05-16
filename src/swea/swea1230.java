import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int T = 10;

        for (int testcase = 0; testcase < T; testcase++) {
            int N = sc.nextInt();   // 암호문 개수
            sc.nextLine();
            List<String> codes = new ArrayList<>();
            String[] code = sc.nextLine().split(" ");   // 원본
            for (int i = 0; i < N; i++) {
                codes.add(code[i]);
            }

            int func = Integer.parseInt(sc.nextLine());    // 암호문 개수
            String[] funcs = sc.nextLine().split(" ");  // 암호문 입력

            int index = 0;
            while( index < funcs.length ){
                if (funcs[index].equals("I")) { // insert : 앞에서부터 x 번째 암호문 다음에 y개의 암호문 s 들을 삽입한다.
                    int x = Integer.parseInt(funcs[++index]);
                    int y = Integer.parseInt(funcs[++index]);
                    String[] ss = new String[y];
                    for (int i = 0; i < y; i++) {
                        ss[i] = funcs[++index];
                    }

                    for (int i = 0; i < y; i++) {
                        codes.add(x+i, ss[i]);
                    }

                } else if (funcs[index].equals("D")) {  // delete : 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.
                    int x = Integer.parseInt(funcs[++index]);
                    int y = Integer.parseInt(funcs[++index]);

                    for (int i = 0; i < y; i++) {
                        codes.remove(x); // x부터 y개를 삭제하므로, 삭제할 때마다 인덱스를 조정할 필요가 없습니다.
                    }

                } else if (funcs[index].equals("A")) { // add : 맨 뒤에 y개의 암호문을 덧붙인다. s는 덧붙일 암호문들이다.
                    int y = Integer.parseInt(funcs[++index]);
                    String[] ss = new String[y];
                    for (int i = 0; i < y; i++) {
                        ss[i] = funcs[++index];
                    }
                    codes.addAll(Arrays.asList(ss)); // 배열을 리스트에 추가합니다.
                }
                index++; // 각 조건문이 실행될 때마다 index를 증가시켜야 합니다.
            }

            // 출력 부분
            System.out.print("#" + (testcase + 1)); // 테스트 케이스 번호 출력
            for (int i = 0; i < Math.min(10, codes.size()); i++) { // 10개까지 출력하거나, 리스트의 크기까지 출력합니다.
                System.out.print(" " + codes.get(i));
            }
            System.out.println(); // 줄 바꿈
        }
    }
}
