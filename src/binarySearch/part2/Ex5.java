package binarySearch.part2;

import java.util.Scanner;

public class Ex5 {
    // 떡볶이 떡 만들기
    // 적절한 높이를 찾을 때까지 이진 탐색 수행하며 높이 H 조정
    // '현재 이 높이로 자르면 조건을 만족할 수 있는가?' 의 만족 여부에 따라 탐색 범위 좁혀나가기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 여러 줄의 떡 길이
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int) 1e9;
        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                // 잘랐을 때의 떡의 양
                if (arr[i] >mid) total += arr[i] - mid;
            }
            if (total < m) { // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                end = mid - 1;
            } else {    // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                result = mid;   // 최대한 덜 잘랐을 때가 정답
                start = mid + 1;
            }
        }
        System.out.println(result);

    }
}
