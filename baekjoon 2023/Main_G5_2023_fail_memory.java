package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G5_2023_fail_memory {
	static int n;
	static int max = 100000000;
	static boolean prime[] = new boolean[max];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int i = 2; i * i < max; i++) {
			if (prime[i]) {
				for (int j = i * i; j < max; j+=i) {
					prime[j] = false;
				}
			}
		}
		
		n = Integer.parseInt(br.readLine());
		
		dfs("", 0);
	}
	
	private static void dfs(String s, int cnt) {
		if (cnt == n) {
			System.out.println(s);
			return;
		}
		for(int i=1; i<=9; i++) {
			if(prime[Integer.parseInt(s+i)]) {
				dfs(s+i,cnt+1);
			}
		}
	}
}