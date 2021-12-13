package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_12871 {
	static String s;
	static String t;
	static int len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		t = br.readLine();
		
		String S = s;
		String T = t;
		
		if (s.length() != t.length()) {
			// 두 문자열의 길이의 최소 공배수를 구해준다.
			len = lcm(s.length(), t.length());
			
			// 구해진 최소 공배수만큼 증가시켜준다.
			while (S.length() != len)
				S += s;
			
			while (T.length() != len)
				T += t;
		}
		
		if (S.equals(T))
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	// 최대 공약수
	public static int gcd(int a, int b) {
		while (b > 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		
		return a;
	}

	// 최소 공배수 => (a * b) / a와 b의 최대 공약수
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}