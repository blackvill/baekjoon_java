package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_25418 {
	static int n;
	static int k;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// dp 계산을 위한 dp 배열
		dp = new int[k + 1];
		
		// n을 k로 만들어야 하므로 n부터 시작할 것 같지만
		// n일때는 0번이므로 n + 1부터 시작
		for (int i = n + 1; i <= k; i++) {
			// 2배를 할 수 있을 때
			if (i / 2 >= n && i % 2 == 0)
				// 1을 더하는 경우와 2를 곱하는 경우를 비교해서 더 작은 값에 연산횟수 1회 증가
				dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
			else
				// 2배가 불가능 한 경우에는 1더하기 연산만
				dp[i] = dp[i - 1] + 1;
		}
		
		// k의 값을 만드는 최소 횟수가 담긴 배열 값 출력
		System.out.println(dp[k]);
	}
}