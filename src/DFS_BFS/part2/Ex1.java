package DFS_BFS.part2;

import java.util.Stack;

public class Ex1 {
    // 스택 구현 예제
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        stackInt.push(5);
        stackInt.push(2);
        stackInt.push(3);
        stackInt.push(7);
        stackInt.pop();
        stackInt.push(1);
        stackInt.push(4);
        stackInt.pop();

        // 스택의 최상단 원소부터 출력
        while (!stackInt.isEmpty()) {
            System.out.println(stackInt.peek());
            stackInt.pop();
        }
    }
}
