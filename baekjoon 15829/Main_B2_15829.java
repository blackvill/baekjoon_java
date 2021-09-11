package BOJ_bronze;

import java.util.Scanner;

public class Main_B2_15829 {
	static final int n = 31;
	static final int mod = 1234567891;
	static int length;
	static long result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		length = sc.nextInt();
		String s = sc.next();

		result = 0; 
		
		for(int i = 0; i < length; i++) {
			result += (s.charAt(i) - 'a' + 1) * pow(n, i) ;
		}
		System.out.println(result % mod);
	}
	
	static long pow(int a, int b) {
		return b == 0 ? 1 : a * pow(a, b-1) % mod;
	}
}
