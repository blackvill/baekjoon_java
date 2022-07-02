package BOJ_gold;

import java.io.*;

public class Main_G5_9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력받기
		String str1 = br.readLine();
		String str2 = br.readLine();
		// dp 배열
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		
		// 1번 문자열로 가로 0으로 초기화
		for(int i = 0; i <= str1.length(); i++)
			dp[i][0] = 0;
		// 2번 문자열로 세로 0으로 초기화
		for(int i = 0; i <= str2.length(); i++)
			dp[0][i] = 0;
		
		/*
		비교하는 위치의 문자가 같으면 현재 위치 값 : 왼쪽 대각선 값 + 1
		비교하는 위치의 문자가 같지 않으면 현재 위치 값 : max(왼쪽 값, 위쪽 값)
	    */
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				// 같은 문자가 나왔다면
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					// 왼쪽 대각선 값 + 1
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else  // 아니라면
					// 왼쪽 값 vs 위쪽 값
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
	}
}