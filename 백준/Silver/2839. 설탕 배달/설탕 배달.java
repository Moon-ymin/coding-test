import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = -1; // 봉지의 개수
		
		// 1. 배달해야하는 설탕의 무게 N
		int N = sc.nextInt();
		// 2. 5kg의 몫
		int kg_5 = N / 5;
		N %= 5;
		
		// 3. while문 
		while(kg_5 >= 0) {
			// 1) 3으로 나눠떨어지는지
			if (N % 3 == 0) {
				result = kg_5 + N / 3;
				break;
			}
			// 2) 3으로 안나눠떨어지면 -> 5kg의 몫 하나씩 줄여서 -> 3으로 다시 나눠지는지
			else {
				N = N + 5;
				kg_5--;
			}
		}
		System.out.println(result);

	}

}