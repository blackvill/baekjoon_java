package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_1890 {
	static int n;
	static int[][] arr;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		arr = new int[n + 1][n + 1];
		dp = new long[n + 1][n + 1];
		
		// 배열 채우기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
		// 시작 1로 초기화
		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 목표지점 도착하면 탈출
				if(i == n - 1 && j == n - 1)
					continue;
				// 다음 값은 현재 배열의 값
				int next = arr[i][j];
				
				// 배열을 벗어나지 않으면
				if (i + next < n) {
					// dp에 값을 추가하기
					dp[i + next][j] += dp[i][j];
				}
				// 배열을 벗어나지 않으면
				if (j + next < n) {
					// dp에 값을 추가하기
					dp[i][j + next] += dp[i][j];
				}
			}
		}
		
		// 결과 출력
		System.out.println(dp[n - 1][n - 1]);
	}
}
