package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S1_4889 {
	static int t = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String str = br.readLine();
			
			// -가 포함되면 연산 종료
			if (str.contains("-"))
				break; 
			
			int n = str.length();
			int cnt = 0;
			Stack<Character> st = new Stack<>();
			
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				
				// 만약, 여는 괄호라면
				if (c == '{') {
					st.add(c); // 그대로 스택에 추가
				}
				else { // 닫는 괄호라면
					// 스택이 비어있는지를 체크
					if (st.isEmpty()) { // 스택이 비어있다면
						st.add('{'); // 여는 괄호를 스택에 추가
						cnt++; // } > {로 변경했으므로 변경 횟수 추가
					}
					// 스택이 비어있지 않다면
					else
						// 스택에서 { 하나를 빼냄
						st.pop();
				}
			}
			// 스택에 남아있는 { 개수를 구해준다.
			int left = st.size();
			// 남아있는 갯수의 반을 }로 변경해주면 안정적인 문자열이 된다.
			cnt += (left / 2);
			
			System.out.println(t + ", " + cnt);
			t++;
		}
	}
}
