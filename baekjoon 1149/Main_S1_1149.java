package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1149 {
	static int n;
	static int[] R;
	static int[] G;
	static int[] B;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		R = new int[n + 1]; // 빨
		G = new int[n + 1]; // 초
		B = new int[n + 1]; // 파
		dp = new int[n + 1][3]; // dp배열
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// RGB의 값을 맨 처음 값에 넣어줌
		dp[0][0] = R[0]; 
		dp[0][1] = G[0]; 
		dp[0][2] = B[0]; 
		
		for (int i = 1; i <= n; i++) {
			// 현재 값을 기준으로 이전 값은 같은 자리를 택하면 안되니까 현재 선택된 자리를 제외한 두 값들 중 최소를 선택
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R[i];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G[i];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B[i];
		}
		// 계산이 완료된 dp계열의 맨 마지막 행은 각 자리의 최소값들이니 이 중에 최소값을 구해야한다.
		int min = Math.min(dp[n][0], dp[n][1]); // 먼저 빨강과 초록 비교
		min = Math.min(min, dp[n][2]); // 다음으로 작은것과 파랑 비교 
		System.out.println(min);
	}
}