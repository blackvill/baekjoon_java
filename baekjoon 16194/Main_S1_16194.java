package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_16194 {
	static int n;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n + 1];
		dp = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i] = arr[i]; // 해당 카드 개수의 카드팩 가격으로 초기화
			
			for (int j = 1; j <= i; j++) {
				// 현재 카드 개수의 최소 가격 vs 특정 개수를 뺀 카드의 최소 가격 + 특정 개수 카드팩 가격 
				dp[i] = Math.min(dp[i], dp[i - j] + arr[j]);
			}
		}
		
		System.out.println(dp[n]);
	}
}