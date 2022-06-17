package BOJ_gold;

import java.util.*;
import java.io.*;

public class Main_G5_2240 {
	static int t, w;
    static int[] arr;
    static int[][][] dp;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        arr = new int[t + 1];
        
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
 
        // dp[위치][시간][이동 횟수] = 먹은 자두 수
        dp = new int[3][t + 1][w + 2];
        
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
            	// 떨어지는 곳이 1번인 경우
                if (arr[i] == 1) {
                	// (이동을 한 경우 vs 이동을 하지 않은 경우) + 해당 위치에 떨어지면 1 아니면 0
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                }
                // 떨어지는 곳이 2번인 경우
                else {
                    if (i == 1 && j == 1)
                    	continue;
                    
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                }
            }
        }
 
        int result = 0;
        
        for (int i = 1; i <= w + 1; i++) {
            result = Math.max(result, Math.max(dp[1][t][i], dp[2][t][i]));
        }
 
        System.out.println(result);
    }
}
