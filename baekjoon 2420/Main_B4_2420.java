package BOJ_bronze;

import java.util.Scanner;

public class Main_B4_2420 {
	static long n;
	static long m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextLong();
		m = sc.nextLong();
		
		System.out.println(Math.abs(n - m));
	}

}
