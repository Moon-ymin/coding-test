import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 부분집합으로 구역 나누기
 * 연결 가능성 체크 하기
 * 인구 차이 계산하기 -> 최소값 구하기 
 */
public class Main {
	static int N, pop[], minDiff = Integer.MAX_VALUE;
	static List<Integer> arr[];

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		pop = new int[N+1];
		arr = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			pop[i] = sc.nextInt();
			arr[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			int k = sc.nextInt();
			for(int j=0; j<k; j++) {
				int neighbor = sc.nextInt();
				arr[i].add(neighbor);
			}
		}
		
		List<Integer> groupA = new ArrayList<>();
		List<Integer> groupB = new ArrayList<>();
		make(1, groupA, groupB);
		
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
		
	}


	private static void make(int i, List<Integer> groupA, List<Integer> groupB) {
		if (i > N) {
			if (!groupA.isEmpty() && !groupB.isEmpty() &&
				isConnect(groupA) && isConnect(groupB)) {
				int popA = getPop(groupA);
				int popB = getPop(groupB);
				minDiff = Math.min(minDiff, Math.abs(popA-popB));
			}
			return;
		}
		
		groupA.add(i);
		make(i+1, groupA, groupB);
		groupA.remove(groupA.size()-1);
		groupB.add(i);
		make(i+1, groupA, groupB);
		groupB.remove(groupB.size()-1);
		
	}


	private static int getPop(List<Integer> group) {
		int total = 0;
		for(int g : group) total += pop[g];
		return total;
	}


	private static boolean isConnect(List<Integer> group) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(group.get(0));
		visited[group.get(0)] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int n : arr[cur]) {
				if (!visited[n] && group.contains(n)) {
					visited[n] = true;
					q.offer(n);
				}
			}
		}
		
		for(int g : group)
			if (!visited[g]) return false;
		return true;
	}
	
	

}