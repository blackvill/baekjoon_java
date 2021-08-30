package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_10833 {
	static int n;
	static int count;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int student = Integer.parseInt(st.nextToken());
			int apple = Integer.parseInt(st.nextToken());
			
			count += (apple % student);
		}
		System.out.println(count);
	}
}
