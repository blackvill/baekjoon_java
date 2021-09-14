package BOJ_silver;

import java.util.Scanner;

public class Main_S3_9461 {
	static int tc;
	static int n;
	static long[] dp = new long[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		tc = sc.nextInt();
		
		for (int t = 0; t < tc; t++) {
			n = sc.nextInt();

			dp[0] = 0;
			dp[1] = dp[2] = dp[3] = 1;
			
			for (int i = 4; i <= 100; i++) {
				dp[i] = dp[i - 2] + dp[i - 3];
			}
			System.out.println(dp[n]);
		}
	}
}