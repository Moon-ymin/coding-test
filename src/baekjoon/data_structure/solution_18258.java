package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer command;
		
		while(N-- > 0) {
			command = new StringTokenizer(br.readLine(), " ");
			
			switch(command.nextToken()) {
			case "push":
				q.offer(Integer.parseInt(command.nextToken()));
				break;
			case "pop":
				Integer item = q.poll();
				if (item == null) {
					sb.append(-1).append("\n");
				} else {
					sb.append(item).append("\n");
				}
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if (q.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				Integer it = q.peek();
				if (it == null) {
					sb.append(-1).append("\n");
				} else {
					sb.append(it).append("\n");
				}
				break;
			case "back":
				Integer i = q.peekLast();
				if (i == null) {
					sb.append(-1).append("\n");
				} else {
					sb.append(i).append("\n");
				}
				break;
			}
			
		}
		System.out.println(sb);
		

	}

}
