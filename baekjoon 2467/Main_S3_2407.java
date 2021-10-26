package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_S3_2407 {
	static BigInteger dp[][];
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new BigInteger[101][101];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					dp[i][j] = new BigInteger("1");
				else
					dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
