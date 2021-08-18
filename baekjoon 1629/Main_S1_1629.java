import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  지수가 짝수인 경우 (y % 2 == 0)
 *   x^y - x^(y/2) * x^(y/2)
 *   
 *  지수가 홀수인 경우 (y % 2 == 1)
 *   x^y - x^(y/2) * x^(y/2) * x
 *   
 *  모듈러 법칙
 *   (a * b) % c = (a % c * b % c) % c
 *   
 *  (a * b) % C = ((a % C)*(b % C)) % C
 *  (temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
 *  = (((temp * temp % C) % C) * (A % C)) % C
 *  // (temp * temp % C) = (temp * temp % C) % C
 *  = ((temp * temp % C) * A) % C
 */

public class Main {
	static long A, B, C;
	static long temp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(power(A, B));
	}
	public static long power(long a, long b) {
		if (b == 1)
			return a % C;
		
		temp = power(a, b / 2);
		
		if (b % 2 == 1) {
			return (temp * temp % C) * a % C;
		}
		return temp * temp % C;
	}
}
