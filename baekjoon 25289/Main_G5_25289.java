package BOJ_gold;

import java.io.*;
import java.util.StringTokenizer;

// 참고)
// https://github.com/minuk8932/Algorithm_BaekJoon/blob/master/src/dynamic_programming/Boj25289.java

public class Main_G5_25289 {
	static int n, sub;
	static int max = Integer.MIN_VALUE;
	static int arr[];
	static int dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		int result = 0;
		// 정수로 주어지므로 차이가 |최고값|을 넘어갈 수 없음
		for (int sub = -1 * max; sub <= max; sub++) {
            dp = new int[max + 1];

            for (int i = 0; i < n; i++) {
            	// 차이값 = 현재값 - 등차값
                int diff = arr[i] - sub;

                // 차이가 max 사이의 양수라면
                if(diff >= 1 && diff <= max) {
                	// dp[현재] = dp[차이] + 1
                    dp[arr[i]] = dp[diff] + 1;
                }
                // 아니라면
                else {
                	// 해당 값은 1
                    dp[arr[i]] = 1;
                }
                // 최고값으로 갱신
                result = Math.max(result, dp[arr[i]]);
            }
        }
		
		System.out.println(result);
	}
}