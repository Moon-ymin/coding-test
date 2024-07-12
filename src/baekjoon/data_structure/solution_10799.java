import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                if (input.charAt(i - 1) == '(') { // 레이저
                    stack.pop();
                    total += stack.size(); // 현재 스택의 크기만큼 추가
                } else { // 막대기 끝
                    stack.pop();
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}

