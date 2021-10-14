package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_2579 {
	static int n;
	static int dp[];
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		n = Integer.parseInt(br.readLine());
 
		// n + 1로 해줘도 되지만 그렇게 하면 dp[2]일 때 if문으로 n>=2일 때로 처리해줘야 한다.
		// 문제에서 계단의 개수는 300개 이하라고 하였으니 그거 + 1인 301로 처리하면
		// 따로 n>=2일 때 처리를 해주지 않아도 된다.
		dp = new int[301];
		arr = new int[301];
 
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		// 초기화
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
 
		for (int i = 3; i <= n; i++) {
			// 연속으로 3칸을 올라갈 수 없기 때문
			dp[i] = Math.max(dp[i - 2] , dp[i - 3] + arr[i - 1]) + arr[i];
		}
 
		System.out.println(dp[n]);
	}
}