package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_17271 {
	static int n, b;
	static int[] dp;
	static int mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		dp = new int[100001];
		
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			// 1초쿨 기술
			dp[i] = dp[i - 1];
			
			// b초쿨 기술
			if (i >= b)
				dp[i] += dp[i - b];
			
			dp[i] %= mod;
		}
		
		System.out.println(dp[n]);
	}

}
