package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_9625 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int k = Integer.parseInt(br.readLine());
        
        // [0][n] : A
        // [1][n] : B
        int[][] dp = new int[2][46];

        // 한번 눌렀을때 - B 1개
        dp[1][1] = 1;
        // 두번 눌렀을때 - A, B 각 1개
        dp[0][2] = 1;
        dp[1][2] = 1;
        
        // A와 B가 각각 피보나치
        for (int i = 3; i <= k; i++) {
            dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
            dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
        }
        
        // A와 B의 개수를 출력
        System.out.print(dp[0][k] + " " + dp[1][k]);
	}
}
