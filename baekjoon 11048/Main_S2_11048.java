package BOJ_silver;

import java.util.*;
import java.io.*;

/*
 * 점화식 = dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i][j - 1]);
 */
public class Main_S2_11048 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n과 m 입력받기
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		
		// 배열에 값 채워주기
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 사탕의 개수는 0보다 크다.
				// 대각선으로 이동하는 것보다 오른쪽으로 갔다가 아래, 아래로 갔다가 오른쪽이 더 많은 사탕을 가지게 된다.
				// 따라서 대각선은 계산해주지 않아도 된다.
				dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}