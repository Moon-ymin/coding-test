import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.next().split("");
		boolean[] visit = new boolean[arr.length];
		
		sorting(arr, visit, 0, arr.length-1);

	}
	private static void sorting(String[] arr, boolean[] visit, int start, int end) {
		if (end < start) return;
		
		// 1. 사전 순으로 가장 작은 문자 찾기
		int minIndex = start;
		for (int i=start; i<=end; i++) {
			if (!visit[i] && arr[i].charAt(0) < arr[minIndex].charAt(0)) minIndex = i;
		}
		
		// 선택한 애 출력하기
		visit[minIndex] = true;
		for(int i=0; i<arr.length; i++) {
			if (visit[i]) System.out.print(arr[i]);
		}
		System.out.println();
		
		// 2. 1에서 찾은 문자보다 뒤에 있는 애들 중에서
		sorting(arr, visit, minIndex+1, end);
		
		// 3. 1에서 찾은 문자보다 앞에 있는 애들 먼저
		sorting(arr, visit, start, minIndex-1);
	}

}