package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_11057 {
	static int n;
	static int dp[][];
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// 앞은 자릿수, 뒤는 1 ~ 10
		dp = new int[n + 1][10];
		
		// 1자리수 일 때의 값들을 1로 저장
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		// 2자리수 이상 일 때 처리
		// [n][k] = 끝자리가 k일 때, n자릿수의 갯수
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		// n자릿수의 값들을 다 더하면 n 자릿수의 총 개수를 알 수 있다.
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
			sum %= 10007; // 더하면서 범위를 더하면 값이 넘어갈 수 있으니까 여기서도 나눠준다.
		}
		
		System.out.println(sum);
	}
}