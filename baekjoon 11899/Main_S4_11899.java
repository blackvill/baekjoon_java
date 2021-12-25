package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S4_11899 {
	static int right;
	static int cnt;
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		stack = new Stack<>();
		
		// 각 괄호들을 스택에 담아준다.
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		
		while (!stack.isEmpty()) {
			// 한 문자씩 잘라서 체크
			char c = stack.pop();
			
			// 만약 닫는 괄호라면
			if (c == ')') {
				right++; // right 카운트를 증가
			}
			// 여는 괄호면서 right가 0이 아니라면 정상적으로 닫을 수 있으니까
			else if (c == '(' && right != 0) {
				right--; // right를 감소
			}
			// 여는 괄호면서 right가 0이라면 정상적이지 않은 괄호니까
			else if (c == '(' && right == 0) {
				cnt++; // 필요한 추가 괄호의 수를 증가
			}
		}
		
		// 모든 스택을 다 비웠는데 닫는 괄호가 남아 있다면
		// 남은 수만큼 여는 괄호가 필요하다는 뜻
		if (right != 0) {
			cnt += right; // 그 수만큼 증가
		}
		
		System.out.println(cnt);
	}
}