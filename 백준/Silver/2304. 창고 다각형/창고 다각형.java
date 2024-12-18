import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 기둥의 개수 N
        int N = sc.nextInt();
        int[][] pills = new int[N][2]; // [L, H]
        for (int i = 0; i < N; i++) {
            pills[i][0] = sc.nextInt();
            pills[i][1] = sc.nextInt();
        }
        // 2. 위치 기준 정렬
        Arrays.sort(pills, Comparator.comparingInt(a -> a[0]));

        // 3. 가장 높은 기둥의 인덱스 찾기
        int maxHeight = 0;
        for(int i = 0; i < N; i++) {
            if (pills[i][1] > pills[maxHeight][1]) maxHeight = i;
        }

        // 4. 왼쪽 넓이 구하기
        Stack<Integer> stack = new Stack<>(); // 인덱스
        stack.push(0);

        int left = 0;
        for(int i=1; i<=maxHeight; i++){
            if (pills[i][1] >= pills[stack.peek()][1]){
                int height = pills[stack.peek()][1];
                int width = pills[i][0] - pills[stack.peek()][0];
                left += height * width;
                stack.push(i);
            }
        }

        // 5. 오른쪽 넓이 구하기
        stack.clear();
        stack.push(N-1);
        int right = 0;
        for(int i=N-2; i>=maxHeight; i--){
            if (pills[i][1] >= pills[stack.peek()][1]){
                int height = pills[stack.peek()][1];
                int width = pills[stack.peek()][0]- pills[i][0];
                right += height * width;
                stack.push(i);
            }
        }
        System.out.println(left + right + pills[maxHeight][1]);
        //System.out.printf("left : %d, right : %d, center : %d, max : %d\n", left, right, pills[maxHeight][1], maxHeight);
    }

}