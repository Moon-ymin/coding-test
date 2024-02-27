package greedy.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    // 모험가 길드 : 공포도가 낮은 사람부터 그룹화해서 최대 그룹 수 나오도록
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int result = 0; // 그룹수
        int count = 0; // 그룹의 인원수

        for(int i=0; i<n; i++) {
            count++;
            if (count >= arr[i]) {
                result++;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
