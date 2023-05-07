import java.io.*;
import java.util.*;

public class Main_S3_17175 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 선언 및 초기화
		long[] dp = new long[51];
		dp[0] = 1;
		dp[1] = 1;
		
		// n 입력받기
		int n = Integer.parseInt(br.readLine());
        
		// 피보나치 실행 횟수 = 1 + dp[i-1] + dp[i-2]
        for (int i = 2; i <= n; i++) {
            dp[i] = (1 + dp[i-1] + dp[i-2]) % 1000000007;
        }
        
        System.out.print(dp[n]);
	}
}