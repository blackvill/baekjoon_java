package BOJ_gold;

import java.io.*;
import java.util.Stack;

public class Main_G4_9252 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		
		for (int i = 0; i <= str1.length(); i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= str2.length(); i++) {
			dp[0][i] = 0;
		}
		
		// LCS 알고리즘 적용
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		
		// LCS의 결과 출력
		System.out.println(dp[str1.length()][str2.length()]);
		
		// 해당 LCS 문자열의 결과를 담기위한 스택
		Stack<Character> stack = new Stack<>();
		
		int a = str1.length();
		int b = str2.length();
		
		// 스택에 담으므로 역순으로 탐색
		while (a != 0 && b != 0) {
			// 같은 문자라면
			if (str1.charAt(a - 1) == str2.charAt(b - 1)) {
				// 스택에 담아주기
				stack.add(str1.charAt(a - 1));
				a--;
				b--;
			}
			// 다른 문자의 경우
			// 왼쪽과 위쪽의 값 중 큰 것을 가지고 왔기 때문에 가져온 값으로 맞춰주기 위해 해당 값을 빼줌 
			else if (dp[a][b] == dp[a - 1][b]) {
				a--;
			} else if (dp[a][b] == dp[a][b - 1]) {
				b--;
			}
		}
		
		// 역순으로 빼주기
		while (!stack.isEmpty())
			System.out.print(stack.pop());
	}
}