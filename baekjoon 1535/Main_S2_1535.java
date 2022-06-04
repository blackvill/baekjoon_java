package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_1535 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[100];
		int[] hp = new int[n];
		int[] happy = new int[n];
		
		// 인사할 때 잃는 체력 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인사할 때 얻는 행복 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			// 인사할 때 드는 체력이 100이 안넘어가는 선에서
			for (int j = 99; j >= hp[i]; j--) {
				// 각 hp를 빼고 행복을 더한 것 vs 현재까지 기쁨
				// 비교해서 더 큰 값을 고르기
				dp[j] = Math.max(dp[j- hp[i]] + happy[i], dp[j]);
			}
		}
		
		// 100이 되면 안되므로 99일 때 최대값을 출력 
		System.out.println(dp[99]);
	}
}