import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int[] arr = new int[X+1];

        arr[0] = 1;
        for (int i=2; i<=X; i++) {
            int min = Integer.MAX_VALUE;

            if (i % 3==0) min = Math.min(arr[i/3]+1, min);
            if (i % 2==0) min = Math.min(arr[i/2]+1, min);
            min = Math.min(arr[i-1]+1, min);

            arr[i] = min;
        }
        System.out.println(arr[X]);
    }
}