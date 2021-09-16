package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_11404 {
	static int n;
	static int m;
	static int dp[][];
	static int max = 500000000; // 최대 100개의 도시를 최대 100000원의 비용들을 내고 이동할 경우보다 큰 수

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1][n + 1];
		
		// 배열을 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) // 자기자신을 가는 경우는 0이기 떄문
					continue;
				dp[i][j] = max;
			}
		}
		// 입력되는 값들을 이용해 최소 비용 배열을 만들어준다.
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()); // 시작
			int end = Integer.parseInt(st.nextToken()); // 도착
			int cost = Integer.parseInt(st.nextToken()); // 비용
			
			dp[start][end] = Math.min(dp[start][end], cost);
		}
		// 플로이드-워셜 알고리즘을 이용해 모든 경우의 최소비용을 갱신해준다.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == i)
					continue;
				for (int k = 1; k <= n; k++) {
					if (k == i || k == j)
						continue;
					dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
					// 현재 저장된 값 vs j > i 비용 + i > k의 비용(경유지를 거치는 경우의 비용)
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] != max) // 갈수 있는 곳이라면 최소비용을 출력하고
					System.out.print(dp[i][j] + " ");
				else // 못가는 곳은 0을 출력
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
