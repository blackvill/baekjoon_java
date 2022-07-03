package BOJ_bronze;

import java.io.*;

public class Main_B2_1977 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 100; i++) {
			int num = i * i;
			if (num >= n && num <= m) {
				sum += num;
				min = Math.min(min, num);
			}
		}
		
		if (sum != 0)
			System.out.println(sum + "\n" + min);
		else
			System.out.println("-1");
	}
}