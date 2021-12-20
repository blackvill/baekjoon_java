package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_13241 {
	static long n;
	static long m;
	static long result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		System.out.println(lcm(n, m));
	}
	
	// 최대 공약수
	public static long gcd(long a, long b) {
		while (b > 0) {
			long temp = a;
			a = b;
			b = temp % b;
		}
		
		return a;
	}

	// 최소 공배수 => (a * b) / a와 b의 최대 공약수
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
}