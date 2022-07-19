package BOJ_bronze;

import java.io.*;

public class Main_B5_25372 {
	static String str;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			
			if (str.length() >= 6 && str.length() <= 9)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}