package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_11060 {
	static int n;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, -1);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 배열에 값 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp[0]을 0으로 초기화
        dp[0] = 0;
 
        // n - 1까지체크
        for (int i = 0; i < n - 1; i++) {
        	// 만약 dp[i]가 -1이라면 이 칸에 올 수 없다는 뜻
        	// 그러므로 넘어간다.
            if (dp[i] == -1) {
                continue;
            }
            
            for (int j = 1; j <= arr[i]; j++) {
            	// 범위를 벗어나지 않고
                if (i + j < n) {
                	// 해당 칸이 -1이거나 i + j의 배열 값이 현재 칸에서 1칸 움직이는 것이 더 클 때
                    if (dp[i + j] == -1 || dp[i + j] > dp[i] + 1) {
                        dp[i + j] = dp[i] + 1; // 갱신
                    }
                }
            }
        }
        
        // 마지막을 출력
        System.out.println(dp[n - 1]);
    }
}