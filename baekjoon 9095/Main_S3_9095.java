package BOJ_silver;

import java.util.Scanner;

public class Main_S3_9095 {
	static int n;
	static int[] dp;
	static int tc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			n = sc.nextInt();
			
			dp = new int[101]; // 큰값으로 설정을 해두지 않으면
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			// 위에서 1,2,3에 해당하는 값이 없는데 값을 넣어 에러 발생한다
			
			for (int i = 4; i <= 100; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			System.out.println(dp[n]);
		}
	}
}