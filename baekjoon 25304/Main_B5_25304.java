package BOJ_bronze;

import java.io.*;
import java.util.*;

public class Main_B5_25304 {
	static int x;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			x -= a * b;
		}
		
		if (x == 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}