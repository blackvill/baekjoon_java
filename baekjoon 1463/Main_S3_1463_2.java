package BOJ_silver;

import java.util.Scanner;

public class Main_S3_1463_2 {
	static int n;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new int[1000001];
	    
	    dp[1] = 0;
	    for (int i = 2; i <= n; i++)
	    {
	        dp[i] = dp[i - 1] + 1; // 1더하기
	        if (i % 2 == 0 && dp[i / 2] + 1 < dp[i])
	            dp[i] = dp[i / 2] + 1;
	        if (i % 3 == 0 && dp[i / 3] + 1 < dp[i])
	            dp[i] = dp[i / 3] + 1;
	    }
	    System.out.println(dp[n]);
	}
}