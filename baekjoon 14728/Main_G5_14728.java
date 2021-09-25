package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14728 {
	static int n;
	static int k;
	static int[][] dp;
	static int[] w;
	static int[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[k + 1][n + 1];
		int [] w = new int[n + 1];
		int [] v = new int[n + 1];

		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= k; i++) {
			for(int j = 1; j <= n; j++) {
				if(i >= w[j]) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - w[j]][j - 1] + v[j]); 
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		System.out.println(dp[k][n]);
	}
}