import java.util.Scanner;

public class Solution {
	static int[] heights;
	static boolean[] isVisited;
	static int N, result;
	static boolean[] isPoss;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		// 1. 테스트 케이스
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			result = 0;
			
			// 2. N 개 산
			N = sc.nextInt();
			heights = new int[N];
			// 3. 공백 기준 산 높이 H 입력 
			for(int i=0; i<N; i++) {
				heights[i] = sc.nextInt();
			}
			// 4. 3개씩 확인 -> 가운데가 양쪽보다 크면 기준으로 생각
			for(int i=0; i<N-2; i++) {
				int start = heights[i];
				int mid = heights[i+1];
				int end = heights[i+2];
				
				if (mid > start && mid > end) {
					isVisited = new boolean[N];
					checkBoundary(i, i+2);
					
				}
			}
			sb.append("#"+t).append(" "+result+"\n");
		}
		System.out.println(sb);
		
	}
	// 5. 기준으로 양쪽에 1씩 증가해서 최대 범위 확인
	private static void checkBoundary(int start, int end) {
		int left = 1, right = 1;
		int startIndex = start, endIndex = end;
		for(int i=start-1; i>=0; i--) {
			if (heights[startIndex--] > heights[i]) left++;
			else break;
		}
		for(int i=end+1; i<N; i++) {
			if (heights[endIndex++] > heights[i]) right++;
			else break;
		}
		result += (left*right);
	}
}