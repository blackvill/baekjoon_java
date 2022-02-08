package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_16395 {
	static int n;
	static int k;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// 범위(1 ≤ k ≤ n ≤ 30)
		dp = new int[31][31];

		// 1행과 2행은 1로 값이 고정
		dp[1][1] = dp[2][1] = dp[2][2] = 1;

		// 2행이후부터
		for(int i = 3; i < n + 1; i++) {
			// 행 == 열의 수
			for(int j = 1; j < i + 1; j++) {
				// 처음이거나 마지막인 경우 == 1
				if(j == 1 || j == i) {
					dp[i][j] = 1;
				}
				// 나머지 - 이전행과 그 왼쪽 값의 합
				else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}