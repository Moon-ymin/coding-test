package DFS_BFS.part2;

public class Ex5 {
    // 2가지 방식으로 구현한 팩토리얼 예제

    // 반복적으로 구현한 n!
    public static int factorial_iterative(int n) {
        int result = 1;
        // 1부터 n까지의 수 차례대로 곱하기
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 재귀적으로 구현한 n!
    public static int factorial_recursive(int n) {
        // n이 1 이하인 경우 1을 반환
        if (n<=1) return 1;
        // n! = n * (n-1)!를 그대로 코드로 작성
        return n * factorial_recursive(n-1);
    }

    public static void main(String[] args) {
        System.out.println("반복적 구현 : " + factorial_iterative(5));
        System.out.println("재귀적 구현 : " + factorial_recursive(5));
    }
}
