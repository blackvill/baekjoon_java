package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G5_2293 {
	static int n, k;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		dp = new int[k + 1];

		// 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 초기화
		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				// 지금 동전보다 더 큰 금액이라면
				if (j >= arr[i])
					// 이전에 해당 동전을 사용하기 전의 횟수를 더하기
					dp[j] += dp[j - arr[i]];
			}
		}

		System.out.println(dp[k]);
	}
}
