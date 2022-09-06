package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_9507 {
	static int n, t;
	static long dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		dp = new long[70]; // 넉넉잡아 70개
		
		// 초기값 설정
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		// dp 배열 채우기
		for (int i = 4; i < 70; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
		}
		
		// 해당 값 출력
		for (int T = 0; T < t; T++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}