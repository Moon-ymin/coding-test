import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		arr = new int[X+1];
		System.out.println(f(X));
	}
	private static int f(int n) {
		if (n==1) return 0;
		if(arr[n]!=0) return arr[n];
		
		int min = Integer.MAX_VALUE;
		
		if (n%3 == 0) min = Math.min(min, f(n/3)+1);
		if (n%2 == 0) min = Math.min(min, f(n/2)+1);
		min = Math.min(min, f(n-1)+1);
		return arr[n] = min;
	}
}