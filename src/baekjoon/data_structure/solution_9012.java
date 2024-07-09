package test;
// Stack 활용
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		Stack<String> st = new Stack<>();
		
		while(T-- > 0) {
			String input = sc.nextLine();
			String[] str = input.split("");
			for(String s : str) {
				if (s.equals("(")) {
					st.push(s);
				} else {
					if(!st.isEmpty() && st.peek().equals("(")) {
						st.pop();
					} else {
						st.push(s);
					}
				}
			}
			System.out.println(st.isEmpty() ? "YES" : "NO");
			st = new Stack<>();
		}
		
		
	}

}
