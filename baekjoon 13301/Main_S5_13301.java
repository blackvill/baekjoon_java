package BOJ_silver;

import java.io.*;

public class Main_S5_13301 {
	static int n;
	static long[] dp;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		dp = new long[n + 1];
		// 초기화
		if (n >= 1)
			dp[1] = 1;
		if (n >= 2)
			dp[2] = 1;
		if (n >= 3)
			dp[3] = 2;
		if (n >= 4) {
			// 피보나치 수열 채우기
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}

		// 둘레 구하기
		// n번 째 타일 길이 * 4 + (n - 1)번 째 타일 길이 * 2
		ans = dp[n] * 4 + dp[n - 1] * 2;
		
		System.out.println(ans);
	}
}