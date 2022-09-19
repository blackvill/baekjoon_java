package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G4_2133 {
	static int n, ans;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		
		if (n % 2 == 1) {
			System.out.println(0);
		}
		else {
			dp[0] = 1;
			dp[2] = 3;
			
			// 홀수는 위에서 걸러지니까 2씩 증가 시키면 됨
			for (int i = 4; i <= n; i += 2) {
				dp[i] = dp[i - 2] * dp[2];
				for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
			}
			
			System.out.println(dp[n]);
		}
	}
}