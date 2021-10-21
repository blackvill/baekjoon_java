package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_11055 {
	static int n; // n
	static int dp[]; // dp 배열
	static int sequence[]; // 입력받은 수열을 담을 배열
	static int result; // 결과
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// 초기화
		dp = new int[n];
		sequence = new int[n];
		result = Integer.MIN_VALUE;
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수열 입력받기
		for(int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		
		// 시작은 항상 자기 자신
		dp[0] = sequence[0];
		
		// 수열 끝까지 탐색
		for(int i = 1; i < n; i++) {
			dp[i] = sequence[i];
			// 앞에 숫자보다 자신이 작은 경우가 나올수 있으니 항상 자기자신을 먼저 담아두고 생각
			
			for(int j = 0; j < i; j++) {
				if(sequence[i] > sequence[j]) { // 현재 값이 이전 값보다 크면
					// 값을 넣어줘야한다.
					// 어떤 값? > 자기 자신 + 이전에 자신보다 작은 경우 중 가장 큰 값
					dp[i] = Math.max(dp[j] + sequence[i], dp[i]);
				}
			}
		}
		
		// 결과를 얻는 과정
		for(int i = 0; i < n; i++) {
			if(dp[i] > result) {
				result = dp[i];
			}
		}
		
		System.out.println(result);
	}
}