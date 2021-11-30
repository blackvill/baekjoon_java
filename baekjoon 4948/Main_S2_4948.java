package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S2_4948 {
	static int n;
	static int max = 123456 * 2 + 1;
	static boolean prime[] = new boolean[max];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Arrays.fill(prime, true);
		
		// 에라토스테네스의 체로 소수 판단
		prime[0] = prime[1] = false;
		
		for (int i = 2; i * i <= max; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= max; j += i) {
					prime[j] = false;
				}
			}
		}
		
		// 무한 반복 테케
		while (true) {
			n = Integer.parseInt(br.readLine());
			
			// 0 입력시 종료
			if (n == 0)
				break;
			
			// 소수의 개수
			int cnt = 0;
			
			// n ~ n*2까지 소수라면 cnt 증가
			for (int i = n + 1; i <= n * 2; i++) {
				if (prime[i])
					cnt++;
			}
			
			// cnt 출력
			System.out.println(cnt);
		}
	}
}