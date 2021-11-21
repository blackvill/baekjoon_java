package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/// https://hyunjiishailey.tistory.com/137
public class Main_G1_11401 {
	static int n;
	static int k;
	static long mod = 1000000007; // 나눌 수
	static long arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new long[n + 1];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			arr[i] = (arr[i - 1] * i) % mod;
		}
		long a = arr[n]; // >> n팩
		long b = (arr[k] * arr[n - k]) % mod; // >> k팩 * (n-k)팩
		
		long exponent = mod - 2;
		long be = 1;
		
		while (exponent > 0) {
			if (exponent % 2 == 1) {
				be = (be * b) % mod;
			}
			b = (b * b) % mod;
			exponent /= 2;
		}
		
		System.out.println(((a % mod) * (be % mod)) % mod);
	}
}