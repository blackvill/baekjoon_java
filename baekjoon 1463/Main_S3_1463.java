package BOJ_silver;

import java.util.Scanner;

public class Main_S3_1463 {
	static int n;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new int[1000001];
	    
	    dp[1] = 0;
	    for (int i = 2; i <= n; i++)
	    {
	        dp[i] = dp[i - 1] + 1;
	        // 이전 값에 1 더하기 (1을 더하는 것은 언제든지 발생가능하기때문에 기본값으로 두고 생각)
	        if (i % 2 == 0) 
	            dp[i] = Math.min(dp[i], dp[i / 2] + 1);
	        // 현재 저장된 횟수와 2을 곱해서 나온 횟수를 비교해서 더 작은걸 저장 
	        if (i % 3 == 0)
	            dp[i] = Math.min(dp[i], dp[i / 3] + 1);
	        // 현재 저장된 횟수와 3을 곱해서 나온 횟수를 비교해서 더 작은걸 저장
	    }
	    System.out.println(dp[n]);
	}
}