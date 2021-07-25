package baekjoon;

import java.util.Scanner;

public class baekjoon_10988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int count = 0;
		
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == str.charAt((str.length() -1) - i))
				count++;
		if (count == str.length())
			System.out.println("1");
		else
			System.out.println("0");
	}

}
