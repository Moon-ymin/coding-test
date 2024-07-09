package test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		int index = 0;
        sb.append("<");
        
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size(); // 리스트의 다음 제거할 인덱스 계산
            sb.append(list.remove(index));
            
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb.toString());
	}

}
