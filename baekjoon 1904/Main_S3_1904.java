package BOJ_silver;

import java.util.Scanner;

public class Main_S3_1904 {
	static int n;
	static long[] dp = new long[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
		}
		System.out.println(dp[n]);
	}
}
