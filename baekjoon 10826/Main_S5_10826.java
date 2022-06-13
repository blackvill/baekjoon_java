package BOJ_silver;

import java.io.*;
import java.math.BigInteger;

public class Main_S5_10826 {
	static BigInteger[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		int n = Integer.parseInt(br.readLine());
		
		dp = new BigInteger[n + 1];
		
		// 0, 1에 각 값을 입력해주기
		dp[0] = new BigInteger("0");
		
		// n이 0으로 들어오면 문제 발생하므로 예외 처리
		if (n >= 1)
			dp[1] = new BigInteger("1");
		
		// 2이상일 경우 dp배열에 피보나치 값 채워넣기
		if (n >= 2) {
			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 1].add(dp[i - 2]);
			}
		}
		
		// 원하는 결과값 출력
		System.out.println(dp[n]);
	}
}