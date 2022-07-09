package BOJ_bronze;

import java.util.*;
import java.io.*;

public class Main_B5_23037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		while (n > 0) {
			int t = n % 10;
			answer += t * t * t * t * t;
			n /= 10;
		}
		
		System.out.println(answer);
	}
}