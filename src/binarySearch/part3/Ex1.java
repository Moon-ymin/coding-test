package binarySearch.part3;

import java.util.Scanner;

public class Ex1 {
    // 읽을거리 : https://st-lab.tistory.com/267
    // 정렬된 배열에서 특정 수의 개수 구하기
    // 시간 복잡도 O(lonN)이라서 선형탐색 안됨, 정렬되어 있어서 이진탐색 접근
    // x가 마지막으로 등장하는 인덱스 - x가 처음으로 등장하는 인덱스
    public static  int lowerBound(int[] arr, int target, int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if (target <= arr[mid]) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public static  int upperBound(int[] arr, int target, int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환
    public static int countByRange(int[] arr, int leftValue, int rightValue){
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 값이 [x,x] 범위에 있는 데이터의 수 계산
        int cnt = countByRange(arr, x, x);

        // 값이 x인 원소 존재여부
        if (cnt == 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
