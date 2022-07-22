package BOJ_bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B5_25238 {
	static int a;
	static int b;
	static double c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if (b != 0)
			c = (double)a / 100 * b;
		
		if (a - c >= 100)
			System.out.println(0);
		else
			System.out.println(1);
	}
}