package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B5_6749 {
	static int third;
	static int second;
	static int sub;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		third = Integer.parseInt(br.readLine());
		second = Integer.parseInt(br.readLine());
		
		sub = second - third;
		System.out.println(second + sub);
	}
}
