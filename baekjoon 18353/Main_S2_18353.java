package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_18353 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		// 입력 배열
		int[] map = new int[n + 1];
		// dp 배열
		int[] dp = new int[n + 1];

		// 입력 값 채워주기
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		// 감소하는 최장길이 부분수열 구하기
		int result = 0;
		for (int i = 1; i <= n; i++) {
			// 시작은 1
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				// 시작값과 이전값들을 비교
				// 이전 값이 크다면
				if (map[j] > map[i]) {
					// dp[j]는 이전까지 감소하는 부분 수열의 길이
					// 현재 길이와 이전까지 연결된 최대길이 + 1과 비교해서 최대값을 갱신
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 최대 길이 구하기
			result = Math.max(result, dp[i]);
		}

		// 전체 병사 수 - 최장길이 부분수열 = 열외 수
		System.out.println(n - result);
	}
}
