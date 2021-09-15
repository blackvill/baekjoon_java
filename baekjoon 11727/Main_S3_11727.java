package BOJ_silver;

import java.util.Scanner;

public class Main_S3_11727 {
	static int n;
	static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		dp = new long[1001];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= 1000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}
		System.out.println(dp[n]);
	}
}