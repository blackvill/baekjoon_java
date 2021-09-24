package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_11066 {
	static int t;
	static int n;
	static int[] chapter;
	static int[] sum;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            
            chapter = new int[n + 1];
            dp = new int[n + 1][n + 1];
            sum = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                chapter[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + chapter[i];
            }
            
            for (int i = 0; i < n ; i++) {
            	dp[i][i + 1] = chapter[i]+ chapter[i + 1];
            }
            
            for (int j = 2; j <= n; j++) {
            	for (int i = 1; j + i <= n; i++) {
            		for (int k = i; k < i + j; k++) {
            			if (dp[i][j + i] == 0) {
            				dp[i][j + i] = dp[i][k] + dp[k + 1][i + j] + sumDist(i, i + j);
            			}
            			else
            				dp[i][j + i] = Math.min(dp[i][j + i], dp[i][k] + dp[k + 1][i + j] + sumDist(i, i + j));
            		}
            	}
            }
//            
//            for (int i = 1; i <= n; i++) {
//            	for (int j = 1; j <= n; j++) {
//            		System.out.print(dp[i][j] + "\t");
//            	}
//            	System.out.println();
//            }
            
            System.out.println(dp[1][n]);
        }
	}
	
	private static int sumDist(int start, int end) {
        if (start == 0) {
            return sum[end];
        }

        return sum[end] - sum[start - 1];
    }
}
