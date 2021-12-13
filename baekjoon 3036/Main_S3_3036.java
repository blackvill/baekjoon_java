package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_3036 {
	static int n; // 원 개수
	static int first; // 첫 번째 원

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		first = Integer.parseInt(st.nextToken());
 
		for (int i = 1; i < n; i++) {
			int other = Integer.parseInt(st.nextToken());
			
			// 최대 공약수로 나누기 위해 최대공약수 구하기
			int gcd = gcd(first, other);
			// 분모와 분자를 최대공약수로 나눠주기 
			System.out.println((first / gcd) + "/" + (other / gcd));
		}
	}

	// 최대공약수
	static int gcd(int a, int b) {
		int r;
 
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}