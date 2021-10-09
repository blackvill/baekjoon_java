package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17845 {
	static int n;
	static int k;
	static int l[];
	static int t[];
	static int dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		l = new int[k + 1];
		t = new int[k + 1];
		dp = new int[k + 1][n + 1];
		
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = Integer.parseInt(st.nextToken());
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (j - t[i] >= 0) // 시간에 맞춰서 해결할수 있다면
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t[i]] + l[i]);
				// 이전 dp값과 지금 시간을 뺀 이전 dp의 값에 현재 중요도를 더한 것을 비교
				// 최고값을 입력
				else { // 안된다면
					dp[i][j] = dp[i - 1][j]; // 이전값 입력
				}
			}
		}
		System.out.println(dp[k][n]);
	}
}