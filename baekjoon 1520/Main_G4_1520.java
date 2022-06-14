package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G4_1520 {
	static int n, m;
	static int map[][];
	static int dp[][];

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dp = new int[n][m];

		// 값 채우기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 방문처리를 위해 -1로 채워주기
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) {
		// 마지막에 도달한 경우
		if (x == n - 1 && y == m - 1) {
			return 1;
		}
		// -1이 아니면 이미 방문한 곳
		if (dp[x][y] != -1) {
			return dp[x][y];
		} else {
			// -1인 경우만 방문
			dp[x][y] = 0;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				
				// 범위를 벗어나는 지 체크
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (map[x][y] > map[nx][ny]) {
					// 현재 값이 더 큰 경우
					dp[x][y] += dfs(nx, ny);
				}
			}

		}
		return dp[x][y];
	}
}