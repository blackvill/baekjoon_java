package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_9465 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int map[][] = new int[2][n + 1];
			int dp[][] = new int[2][n + 1];
			
			// 입력받기
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int k = 1; k <= n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 초기화
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for (int j = 2; j <= n; j++) {
				// 1칸 대각선 or 2칸 대각선만 가능
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}