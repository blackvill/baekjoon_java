package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_17626 {
	static int n;
	static int dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
 
        dp = new int[n + 1];
        dp[1] = 1;
 
        int min = 0;
        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            
            // 제곱을 뺏을 때의 최소 개수와 현재 최소 개수
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
 
            dp[i] = min + 1; 
        }
        
        System.out.println(dp[n]);
	}
}