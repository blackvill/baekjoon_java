package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1932 {
	static int n;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j <= i; j++)
				dp[i][j] = Integer.parseInt(st.nextToken());
		}

		// 맨 밑에서부터 위로 올라가면서
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++)
				// 본인과 그  왼쪽에 값을 비교해서 더 큰값을 선택
				// 그 후 위에 값과 합치기
				dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]);
		}
		
		// 가장 큰값들을 고르면서 위로 올라가면 마지막에 남은 학이 가장 큰 합
		System.out.println(dp[0][0]);
	}
}