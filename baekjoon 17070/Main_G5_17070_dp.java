package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070_dp {
	static int n;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n + 1][n + 1][3];
		// 0일때 가로
		// 1일때 세로
		// 2일때 대각선
		dp[1][2][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 3; j <= n; j++) {
				if (map[i][j] == 1) // 이동 불가
					continue;
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				
				if (i == 1) // 시작하는 라인이면 가로만 나올수 있음
					continue;
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				
				if (map[i - 1][j] == 1 || map[i][j - 1] == 1) // 대각선으로 움직이려면 왼쪽과 위가 벽인지 확인해야함
					continue;
				dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}
		
		int result = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
		System.out.println(result);
	}
}
