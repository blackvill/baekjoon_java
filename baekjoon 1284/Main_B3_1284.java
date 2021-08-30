package BOJ_bronze;

import java.util.Scanner;

public class Main_B3_1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int n = sc.nextInt();
			
			if (n == 0)
				break;
			
			int len = 1;
			while (n > 0) {
				int num = n % 10;
				if (num == 0)
					len += 5;
				else if (num == 1)
					len += 3;
				else
					len += 4;
				n /= 10;
			}
			System.out.println(len);
		}
	}
}