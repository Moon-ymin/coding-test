package sorting.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> distance = new ArrayList<>();

        for (int i = 0; i < n; i++) {   // 집 위치 입력 받기
            distance.add( sc.nextInt() );
        }

        Collections.sort(distance);

        System.out.println(distance.get((n - 1) / 2));
        
    }
}
