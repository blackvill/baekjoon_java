package BOJ_silver;

import java.io.*;

public class Main_S2_15988 {
	static int n;
	static long[] dp;
	static int mod = 1000000009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		// dp 값 채우기
		dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 1000000; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
		
		// 입력에 해당하는 값 출력
		for(int i = 0; i < n; i++){
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}