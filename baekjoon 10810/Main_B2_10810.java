package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_10810 {
	static int n;
	static int m;
	static int[] basket;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		basket = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			setBall(s, e, b);
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(basket[i] + " ");
		}
	}
	
	public static void setBall(int start, int end, int ballNum) {
		for (int i = start; i <= end; i++) {
			basket[i] = ballNum;
		}
	}
}