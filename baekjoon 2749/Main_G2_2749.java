package BOJ_gold;

import java.util.Scanner;

public class Main_G2_2749 {
	static long n;
	static int pisano = 1500000;
	static long[] dp = new long[pisano];
	// 피사노 주기
	// 피보나치 수를 나눌 수를 k라고 할 때
	// k = 10 ^ n 이면
	// 피사노 주기는 15 * 10 ^ (n - 1)이다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextLong();
		
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < pisano && i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
		}
		
		if (n >= pisano)
			n %= pisano;
		
		System.out.println(dp[(int) n]);
	}
}
