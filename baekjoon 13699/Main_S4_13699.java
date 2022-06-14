package BOJ_silver;

import java.io.*;

public class Main_S4_13699 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[36];
        
        // 초기값
        dp[0] = 1;
        dp[1] = 1;
        
        // 점화식
        for (int i = 2; i < 36; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - 1 - j]);
            }
        }
        
        System.out.println(dp[n]);
	}
}