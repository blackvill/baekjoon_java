package BOJ_bronze;

import java.util.Scanner;

public class Main_B1_2748 {
	static int n;
	static long[] dp = new long[91];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[n]);
	}

}
