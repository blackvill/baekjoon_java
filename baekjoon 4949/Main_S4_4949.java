package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S4_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		Stack<Character> stack = new Stack<>();
		String s;
		
		while(true) {
			s = br.readLine();
			if(s.equals(".")) {	// 종료 조건문 
				break;
			}
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);	// i 번째 문자 
				// 여는 괄호일 경우 스택에 push 
				if(c == '(' || c == '[')
					stack.push(c);
				// 닫는 소괄호 일 경우 
				else if(c == ')') {
					// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
					if(stack.isEmpty() || stack.peek() != '(') {
						stack.push(c);
						break;
					}
					else 
						stack.pop();
				}
				else if(c == ']') {
					// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
					if(stack.isEmpty() || stack.peek() != '[') { 
						stack.push(c);
						break;
					}
					else 
						stack.pop();
				}
			}
			if(stack.empty()) 
				System.out.println("yes");
			else 
				System.out.println("no");
			stack.clear();
		}
	}
}
