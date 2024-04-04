package greedy.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex5_2 {
    // 조합 이용해서 풀어 봄
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n]; // 공의 무게들
        int[] weight = new int[m];  // 무게 별로 공이 몇 개인지, 인덱스 주의
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            arr[i] = number;
            weight[number-1]++;
        }
        Arrays.sort(arr);   // [1 3 2 3 2] -> [1 2 2]

        // 조합 이용 nC2 - 무게 별 같은 무게 공 C2 - 무게 별 같은 무게 공 C2 ...
        ArrayList<Integer> weight2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if ( weight[i] >= 2){
                weight2.add( weight[i] );   // [ 2 2 ]
            }
        }
        // 전체 조합
        int result = comb(n, 2);
        for (int i = 0; i < weight2.size(); i++) {
            result -= comb(weight2.get(i),2);
        }

        System.out.println(result);

    }
    static int comb(int n, int r){
        if (r==0 || r == n) {
            return 1;
        } else {
            return comb(n-1, r-1) + comb(n-1, r);
        }
    }
}
