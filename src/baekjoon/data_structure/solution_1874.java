package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N 입력받기 : 1~N 까지 스택
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int start = 0;
		
		while(N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			
			if (value > start) {
				// start + 1부터 입력받은 value 까지 push 한다
				for(int i=start+1; i<=value; i++) {
					s.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			} else if (s.peek() != value) {
				System.out.println("NO");
				return;
			}
			s.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
		
		
	}

}
