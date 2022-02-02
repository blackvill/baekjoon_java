package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_15726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double a = Integer.parseInt(st.nextToken());
		double b = Integer.parseInt(st.nextToken());
		double c = Integer.parseInt(st.nextToken());
		
		int num = Integer.max((int)(a * b / c), (int)(a / b * c));
		
		System.out.println(num);
	}
}