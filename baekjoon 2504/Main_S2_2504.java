package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S2_2504_김재욱 {
	static Stack<Character> stack;
	static int ans = 0; // 정답
	static String str; // 입력받을 괄호
	static boolean match = true; // 유효성 체크

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		stack = new Stack<>();
		int cnt = 1;
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			
			// (있으면 2를 곱해야 함
			if (cur == '(') {
				stack.push(cur);
				cnt *= 2;
			}
			// [이 있으면 3을 곱해야 함
			else if (cur == '[') {
				stack.push(cur);
				cnt *= 3;
			}
			else {
				// )으로 올 경우
				if (cur == ')') {
					// 스택이 비어있거나 스택의 맨 위가 (이 아니라면
					if (stack.isEmpty() || stack.peek() != '(') {
						match = false; // 제대로 안되어 있는 거
						break;
					}
					// 이전값이 (라면
					if (str.charAt(i - 1) == '(') {
						ans += cnt; // ()로 되는 거니까 값을 더해준다.
					}
					stack.pop(); // 들어와 있는 값을 뺴줌
					cnt /= 2; // ()의 2를 계산해서 줬으니까 나눠줌
				}
				else if (cur == ']') { // ]이라면
					// 스택이 비어있거나 스택의 맨 위가 ]이 아니라면 
					if (stack.isEmpty() || stack.peek() != '[') {
						match = false; // 제대로 안되어 있는 거
						break;
					}
					// 이전 값이 [라면
					if (str.charAt(i - 1) == '[') {
						ans += cnt; // []로 되는 거니까 값을 더해준다.
					}
					stack.pop(); // 들어와 있는 값을 뺴줌
					cnt /= 3; // []의 3를 계산해서 줬으니까 나눠줌
				}
				else {
					match = false;
					break;
				}
			}
		}
		
		// 괄호가 이상한 경우 or 스택이 남아있는 경우
		if(!match || !stack.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(ans);
		}
	}
}