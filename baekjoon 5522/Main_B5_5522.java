package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B5_5522_김재욱 {
	static long n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			n += Integer.parseInt(br.readLine());
		}
		
		System.out.println(n);
	}
}