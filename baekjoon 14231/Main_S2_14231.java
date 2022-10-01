package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_14231 {
	static int n;
	static int[] arr;
	static int[] dp;
	static int check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for (int i = 1; i <= n; i++) {
			// 시작은 1
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				// 시작값과 이전값들을 비교
				// 이전 값이 크다면
				if (arr[j] < arr[i]) {
					// 현재 길이와 이전까지 연결된 최대길이 + 1과 비교해서 최대값을 갱신
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 최대 크기 구하기
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}