// 정답 코드
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테케
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int eleven = 0;
			int seven = 0;
			int five = 0;
			int three = 0;
			int two = 0;
			
			  while(N % 11 == 0) {
				eleven++;
				N = N / 11;
			  }
			  while(N % 7 == 0) {
				seven++;
				N = N / 7;
			  }
			  while(N % 5 == 0) {
				five++;
				N = N / 5;
			  }
			  while(N % 3 == 0) {
				three++;
				N = N / 3;
			  }
			  while(N % 2 ==0) {
				two++;
				N = N / 2;
			  }
		    System.out.println("#"+t+" " + two +" " + three+" " + five+" " + seven +" " + eleven);
		}
     }
  }

/* 런타임 오류 코드 
  (Runtime error)
  Error Message:
  Memory error occured, (e.g. segmentation error, memory limit Exceed, stack overflow,... etc) 
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int[] nums = {2, 3, 5, 7, 11};
        for (int testcase = 1; testcase <= T; testcase++) {
            int[] result = new int[5];
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < nums.length; i++) {
                while(num % nums[i] == 0){
                    result[i]++;
                    num = num / nums[i];
                }
            }
            System.out.print("#" + testcase + " ");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }
    }
}

/*
  IDE 에서는 문제 없었는데, SWEA 에서는 문제 있었음 : chatGPT 에 물어봄

  1. 각 입력값에 대해 소인수 분해를 수행하고 그 결과를 배열에 저장하고 있습니다. 
      이 때, 입력값이 매우 큰 경우에는 배열의 크기가 커지게 되어 메모리를 많이 사용할 수 있습니다.
  
  2. 입력값이 소인수로 나누어지는지 확인하기 위해 while 루프를 사용하고 있습니다. 
      이 경우 입력값이 소인수로 나누어지지 않는 경우에도 루프를 반복하며 계속해서 처리하므로 메모리를 낭비할 수 있습니다.
  
  이를 고려하여 코드를 수정해야 합니다. 아래는 코드 수정을 위한 몇 가지 제안입니다
  
  1. 입력값이 소인수로 나누어질 때만 카운트를 하고, 그렇지 않은 경우에는 다음 소인수로 넘어가도록 수정합니다. 
      이렇게 하면 불필요한 루프를 줄일 수 있습니다.
  
  2. 배열 대신에 필요한 변수를 사용하여 각 소인수의 개수를 카운트합니다. 이렇게 하면 메모리 사용을 최소화할 수 있습니다.
  
  3. 입력값이 소인수로 나누어질 때마다 입력값을 갱신하여 메모리를 절약할 수 있습니다.
  
  이러한 수정을 통해 메모리 사용을 최적화하고, 메모리 오류를 방지할 수 있습니다. 
*/
