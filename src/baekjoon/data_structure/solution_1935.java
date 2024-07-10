import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        Stack<Double> stack = new Stack();
        String pattern = "+,*,/,-";
        double temp_result = 0;

        // 피연산자(숫자)
        Double[] arr = new Double[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        // 피연산자, 연산자 분기 처리
        for (int i=0; i<chars.length; i++) {
            String chracter = Character.toString(chars[i]);
            if ( !pattern.contains(chracter) ) {         // 피연산자면 stack에 push
                stack.push(arr[chars[i] - 'A']);
            } else {                                    // 연산자면 stack에서 2개 꺼내서 연산
                double num2 = stack.pop();
                double num1 = stack.pop();

                temp_result = getCalculate(chracter, num1, num2, temp_result);
                stack.push(temp_result);
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }

    // 연산자 계산 메서드
    static double getCalculate(String operator, double num1, double num2, double temp_result) {
        switch (operator) {
            case "+":
                temp_result = num1 + num2;
                break;
            case "*":
                temp_result = num1 * num2;
                break;
            case "/":
                temp_result = num1 / num2;
                break;
            case "-":
                temp_result = num1 - num2;
                break;
        }
        return temp_result;
    }
}
