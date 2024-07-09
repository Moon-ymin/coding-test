package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> s = new Stack<>();
		StringTokenizer Command;
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			Command = new StringTokenizer(br.readLine(), " ");
			switch(Command.nextToken()) {
			case "push":
				Integer x = Integer.parseInt(Command.nextToken());
				s.push(x);
				break;
			case "pop":
				if (s.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(s.pop()).append("\n");
				}
				break;
			case "size":
				sb.append(s.size()).append("\n");
				break;
			case "empty":
				if (s.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "top":
				if (s.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(s.peek()).append("\n");
				}
				break;
			}
			
		}
		System.out.println(sb);

	}

}
