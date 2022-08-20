package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S4_14495 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		// int의 범위를 벗어나기 때문에 long형으로 선언
		long[] dp = new long[n];
		
		dp[0] = 1;
		
		if (n >= 2)
			dp[1] = 1;
		if (n >= 3)
			dp[2] = 1;
		if (n >= 4) {
			for (int i = 3; i < n ; i++) {
				dp[i] = dp[i - 3] + dp[i - 1];
			}
		}
		
		System.out.println(dp[n - 1]);
	}
}