package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_2257 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
            
            // 닫는 괄호일때
			if (c == ')') { 
				int num = 0;
				while (true) {
					// 여는 괄호가 오면
					if (s.peek() == 0) {
						s.pop(); // 여는 괄호 제거
						s.push(num); // 지금까지 합한 값 넣기
						break;
					}
					// 값 더하기
					num += s.pop();
				}
			} 
			else if (c == 'C') // 탄소 12
				s.push(12);
			else if (c == 'H') // 수소 1
				s.push(1);
			else if (c == 'O') // 산소 16
				s.push(16);
            // 숫자일 때
			else if (c >= '0' && c <= '9') 
				// 스택 마지막 값 * 현재 숫자
				s.push(s.pop() * (c - '0'));
			// 여는 괄호를 0으로 표시 (0은 올 일이 없으므로 0으로 체크)
			else 
				s.push(0);
		}
		
		int ans = 0;
		
		while(!s.isEmpty()) {
			// 모든 값 다 더하기
			ans += s.pop(); 
		}
		
		System.out.println(ans);
	}
}
