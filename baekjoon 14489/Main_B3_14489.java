package BOJ_bronze;

import java.util.Scanner;

public class Main_B3_14489 {
	static int a;
	static int b;
	static int chicken;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt(); // 통장 1
		b = sc.nextInt(); // 통장 2
		chicken = sc.nextInt(); // 1마리 가격
		chicken *= 2; // 치킨 2마리 
		
		if (a + b < chicken)
			System.out.println(a + b);
		else
			System.out.println((a + b) - chicken);
	}

}
