package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S4_10211 {
	static int n, t;
	static int dp[];
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < t ; T++) {
			int n = Integer.parseInt(br.readLine());
			
            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];
            
            // 값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = arr[1];
    		dp[1] = arr[1];
    		
    		for(int i = 2; i <= n; i++) {
    			// 누적합의 값이 0보다 작아지면 무조건 이후의 값부터 시작하는 것이 커짐
    			// 따라서 0으로 초기화
    			if (dp[i - 1] < 0)
    				dp[i - 1] = 0;
    			
    			// 이전까지의 누적합 + 현재의 값
    			dp[i] = dp[i - 1] + arr[i];
    			// dp와 지금까지의 최대값을 비교해 최대값 갱신
    			max = Math.max(max, dp[i]);
    		}
    		
    		System.out.println(max);
		}
	}
}