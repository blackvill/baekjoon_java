package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_1788 {
	static long mod = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 100만을 더해서 기준을 100만으로 잡아준다.
		int n = Integer.parseInt(br.readLine()) + 1000000;
        long[] dp = new long[2000001];
        
        // 0 위치
        dp[1000000] = 0;
        // 1 위치
        dp[1000001] = 1;
        
        // 음수일 때
        if (n < 1000000) {
            for (int i = 999999; i >= n; i--) {
            	// 점화식 : dp[i + 2] - dp[i + 1]
                dp[i] = (dp[i + 2] - dp[i + 1]) % mod;
            }
        }
        // 짝수일 때
        else {
            for (int i = 1000002; i <= n; i++) {
            	// 점화식 : dp[i - 1] + dp[i - 2]
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
        }
        
        // 0일 때
        if (dp[n] == 0)
        	System.out.println("0");
        // 양수일 때
        else if (dp[n] > 0)
        	System.out.println("1");
        // 음수일 때
        else
        	System.out.println("-1");
        
        System.out.println(Math.abs(dp[n]));
	}
}