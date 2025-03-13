import java.io.*;

public class Main {
    static int N;
    static char[] expr;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expr = br.readLine().toCharArray();

        dfs(0, expr[0] - '0');

        System.out.println(maxResult);
    }

    // 연산 수행 함수
    public static int calculate(int a, char op, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return 0;
        }
    }

    // DFS 탐색 (index: 현재 위치, currentValue: 현재까지의 계산 값)
    public static void dfs(int index, int currentValue) {
        // 종료 조건: 식의 끝까지 왔을 때 최댓값 갱신
        if (index >= N - 1) {
            maxResult = Math.max(maxResult, currentValue);
            return;
        }


        int nextValue = calculate(currentValue, expr[index + 1], expr[index + 2] - '0');
        dfs(index + 2, nextValue);

        if (index + 3 < N) { // 괄호를 사용할 수 있는 경우
            int bracketValue = calculate(expr[index + 2] - '0', expr[index + 3], expr[index + 4] - '0');
            int newValueWithBracket = calculate(currentValue, expr[index + 1], bracketValue);
            dfs(index + 4, newValueWithBracket);
        }
    }
}
