package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_17413 {
	static boolean check = false;
	static String s;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack();
		s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				print(stack); // <를 만나면 여태껏 저장해둔 문자열 거꾸로 출력
				check = true;
				System.out.print(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				check = false;
				System.out.print(s.charAt(i));
			} else if (check) {
				System.out.print(s.charAt(i));
			}
			else {
				if (s.charAt(i) == ' ') {
					print(stack);
					System.out.print(s.charAt(i));
				}
				else {
					stack.push(s.charAt(i));
				}
			}
		}
		print(stack);
	}
	
	static void print(Stack stack) {
		while (!stack.empty()) {
			System.out.print(stack.peek());
			stack.pop();
		}
	}
}