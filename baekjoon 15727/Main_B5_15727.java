package BOJ_bronze;

import java.util.Scanner;

public class Main_B5_15727 {
	static int l;
	static int t;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		
		t += (l / 5);
		
		if (l % 5 == 0)
			System.out.println(t);
		else
			System.out.println(t + 1);
	}
}