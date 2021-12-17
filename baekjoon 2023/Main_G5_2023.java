package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G5_2023 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		dfs("", 0);
	}
	
	private static void dfs(String s, int cnt) {
		if (cnt == n) {
			System.out.println(s);
			return;
		}
		for(int i=1; i<=9; i++) {
			if(prime(Integer.parseInt(s+i))) {
				dfs(s+i,cnt+1);
			}
		}
	}
	
	private static boolean prime(int num) {
		if(num == 1)
			return false;
		
		int sqrt = (int)Math.sqrt(num);
		for(int i = 2; i <= sqrt; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
}