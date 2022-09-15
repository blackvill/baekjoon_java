package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_16493 {
	static int n;
	static int m;
	static int[] dp;
	static int[] day, page;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int[n + 1];
		day = new int[m];
		page = new int[m];
		
		// 입력받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			day[i] = Integer.parseInt(st.nextToken());
			page[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = n; j >= day[i]; j--) {
				dp[j] = Math.max(dp[j - day[i]] + page[i], dp[j]);
			}
		}
		
		System.out.println(dp[n]);
	}
}