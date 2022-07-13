package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_13239 {
	static int mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int dp[][] = new int[1001][1001];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 초기값을 1로 고정
			dp[0][0] = dp[1][0] = dp[1][1] = 1;
			
			// nCr = n-1Cr-1 + n-1Cr 을 이용함
			for (int j = 2; j <= a; j++) {
				for (int k = 0; k <= b; k++) {
					if (j == k || k == 0)
						dp[j][k] = 1;
					else
						dp[j][k] = (dp[j - 1][k - 1] + dp[j - 1][k]) % mod;
				}
			}
			
			System.out.println(dp[a][b]);
		}
	}

}
