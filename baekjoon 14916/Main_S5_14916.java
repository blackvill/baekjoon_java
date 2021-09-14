package BOJ_silver;

import java.util.Scanner;

public class Main_S5_14916 {
	static int n; // 입력받을 돈
	static long[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		dp = new long[n + 1][2]; 
		// [i][0]번지는 잔돈의 갯수 
		// [i][1]번지는 그 때의 남은 잔돈
		
		dp[0][0] = 0;
		dp[0][1] = n; // 시작할때 잔돈은 입력받은 돈
		
		for (int i = 1; i <= n; i++) {
			long min = Integer.MAX_VALUE;
			long change = -1; // 처리가 안될 경우 출력을 -1을 해줘야 하므로 -1로 설정
			
			if (i >= 2 && dp[i - 2][0] + 1 < min) {
				min = dp[i - 2][0] + 1; // 잔돈의 개수 계산
				change = dp[i - 2][1] - 2; // 잔돈의 금액 계산
			}
			if (i >= 5 && dp[i - 5][0] + 1 < min) {
				min = dp[i - 5][0] + 1; // 잔돈의 개수 계산
				change = dp[i - 5][1] - 5; // 잔돈의 금액 계산
			}
			
			dp[i][0] = min; // 계산된 잔돈의 개수를 넣기
			dp[i][1] = change; // 계산된 잔액 넣기
		}
		if (dp[n][1] != 0) // 거슬러 줄 수 없는 경우
			System.out.println(dp[n][1]);
		// 계산이 불가능한 경우에는 -1을 넣어뒀기 때문에 그대로 출력해도 괜찮다
		else
			System.out.println(dp[n][0]);
		// 계산이 되면 잔돈의 개수를 출력
	}
}
