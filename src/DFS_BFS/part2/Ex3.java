package DFS_BFS.part2;

public class Ex3 {
    // 무한히 반복되는 재귀함수 예제
    public static void recursiveFunction() {
        System.out.println("재귀 함수를 호출합니다.");
        recursiveFunction();
    }
    public static void main(String[] args) {
        recursiveFunction();
    }
}
