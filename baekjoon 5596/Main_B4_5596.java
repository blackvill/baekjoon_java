package BOJ_bronze;

import java.io.*;
import java.util.*;

public class Main_B4_5596 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = 0;
		int t = 0;
		
		for (int i = 0; i < 4; i++) {
			s += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			t += Integer.parseInt(st.nextToken());
		}
		
		if (s >= t)
			System.out.println(s);
		else
			System.out.println(t);
		
	}
}