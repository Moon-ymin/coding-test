package binarySearch.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
    // 공유기 설치
    // https://st-lab.tistory.com/277
    public static int[] house;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }
        Arrays.sort(house);

        int lo = 1; // 최소 거리가 가질 수 있는 최소값
        int hi = house[n-1] - house[0] + 1;     // 최소 거리가 가질 수 있는 최댓값

        while(lo < hi) {    // upper bound 형식
            int mid = (hi+lo) / 2;
            // mid 거리에 대해 설치 가능한 공유기 개수가 c개에 못미치면 거리를 좁혀야해서 hi를 줄임
            if (canInstall(mid) < c) {
                hi = mid;
            } else {
                // 설치 가능한 공유기 개수가 c개보다 크거나 같으면 거리를 벌리면서
                lo = mid + 1;
            }
        }
        System.out.println(lo-1);
    }
    public static int canInstall(int distance) {
        int cnt = 1;
        int lastLocate = house[0];
        for (int i = 1; i < house.length; i++) {
            int locate = house[i];

            if(locate - lastLocate>=distance) {
                cnt++;
                lastLocate = locate;
            }
        }
        return cnt;
    }
}
