package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        // 와인  크기 입력받기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0]; // 첫번 째 잔을 마신 경우가 최대
        if (n >= 2)
        	dp[1] = arr[0] + arr[1]; // 첫째, 둘째를 둘 다 마신 경우가 최대
        
        if (n >= 3)
        // 첫째, 둘째를 마신 경우 vs 첫째, 셋째를 마신 경우 vs 둘째, 셋째를 마신 경우
        	dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        if (n >= 4) {
	        for (int i = 3; i < n; i++) {
	        	// 이전에 2개를 마신 경우 vs 2개 이전 + 현재의 와인을 마신 경우 vs 3개전의 와인 누적합 + 직전과 현재의 와인을 마신 경우
	            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
	        }
        }

        System.out.println(dp[n - 1]);
	}
}