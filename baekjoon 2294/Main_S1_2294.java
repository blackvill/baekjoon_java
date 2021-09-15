package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2294 {
	static int n;
	static int k;
	static long[] dp;
	static int[] money;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		money = new int[n];
		dp = new long[10001];
		
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		
		for (int i = 1; i <= k; i++) {
			long min = Integer.MAX_VALUE;
			
			for (int j = 0; j < n; j++) {
				if (i >= money[j] && dp[i - money[j]] + 1 < min)
					min = dp[i - money[j]] + 1;
			}
			dp[i] = min;
		}
		if (dp[k] == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(dp[k]);
	}
}
