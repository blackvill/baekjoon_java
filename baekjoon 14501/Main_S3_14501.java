package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_14501 {
	static int dp[];
	static int t[];
	static int p[];
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
				
		t = new int[n];
		p = new int[n];
		
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken()); // 일정
			p[i] = Integer.parseInt(st.nextToken()); // 비용
		}
		
		dp = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			// 날짜를 넘어가는 지 체크
			if (i + t[i] <= n)
				// (현재 날짜 + 상담 완료)날짜에 저장된 최대 수입 vs (오늘 이전까지 최대 수입 + 오늘 버는 수입) 
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			
			// 상담이 진행되는 중에도 0원이 아닌 이전의 최대 금액이 되어야함
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.println(dp[n]);
	}
}