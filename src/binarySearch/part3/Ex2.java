package binarySearch.part3;

import java.util.Scanner;

public class Ex2 {
    // 고정점 찾기
    // 시간복잡도 O(logN) : 선형탐색 안되고, 이진탐색으로 진행
    public static int binarySearch(int[] arr, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if (arr[mid] == mid) return mid;
            else if (arr[mid] > mid) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = binarySearch(arr,0,n-1);
        System.out.println(cnt);
    }
}
