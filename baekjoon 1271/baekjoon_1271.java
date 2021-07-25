package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class baekjoon_1271 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BigInteger money = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		System.out.println(money.divide(m));
		System.out.println(money.remainder(m));
	}

}
