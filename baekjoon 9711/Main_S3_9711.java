package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_S3_9711 {
	static BigInteger[] dp = new BigInteger[10001];
	static int n;
	static int p;
	static BigInteger q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		
		// 최대 범위까지의 피보나치를 구함
		for (int j = 2; j < dp.length; j++) {
			dp[j] = dp[j - 1].add(dp[j - 2]);
		}
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			p = Integer.parseInt(st.nextToken());
			q = new BigInteger(st.nextToken());
			
			// 해당 피보나치값을 q로 나눠주고 출력
			System.out.println("Case #" + i + ": " + dp[p].remainder(q));
		}
	}
}