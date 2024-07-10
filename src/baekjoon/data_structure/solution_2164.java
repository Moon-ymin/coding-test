// 1. 처음 시간 초과 떴음 - 자료구조 수정해야함
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// N장의 카드
		int N = sc.nextInt();
		// 카드 넣어두는 자료구조 큐 활용
		ArrayList<Integer> q = new ArrayList<>();
		// 1~N까지 카드 넣기
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		// 마지막 카드 수가 1이 될 때 까지 
		while(q.size() > 1) {
			// 1. 제일 위에 있는 카드 바닥에 버림
			q.remove(0);
			// 2. 그 다음 카드는 제일 밑으로 옮김
			int card = q.get(0);
			int index = q.size()-1;
			q.remove(0);
			if (index==0) {
				q.add(0,card);
			} else {
				q.add(index, card);
			}
		}
		System.out.println(q.get(0));
		
	}

}
/*
ArrayList는 인덱스 접근이 빠르지만, 첫 번째 요소를 제거하는 작업은 O(N), 
총 시간 복잡도는 O(N^2) 가 됨 -> 비효율
Queue 자료구조 활용
*/
// 2. Queue 자료구조 활용
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N장의 카드
		int N = sc.nextInt();
		// 카드 넣어두는 자료구조 큐 활용
		Queue<Integer> q = new LinkedList<>();
		// 1~N까지 카드 넣기
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		// 마지막 카드 수가 1이 될 때 까지 
		while(q.size() > 1) {
			// 1. 제일 위에 있는 카드 바닥에 버림
			q.poll();
			// 2. 그 다음 카드는 제일 밑으로 옮김
			q.add(q.poll());
		}
		System.out.println(q.poll());
		
	}

}
