package BOJ_silver;

import java.util.Scanner;

public class Main_S3_2193 {
	static int n;
	static long[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new long[101][2];
		
		dp[0][0] = dp[1][0] = dp[0][1] = 0;
		dp[1][1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}
		
		System.out.println(dp[n][0] + dp[n][1]);
	}

}
