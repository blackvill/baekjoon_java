package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B4_11948 {
	static int a[] = new int[4];
	static int b[] = new int[2];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 4; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < 2; i++) {
			b[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 1; i < 4; i++) {
			ans += a[i];
		}
		
		System.out.println(ans + b[1]);
	}
}