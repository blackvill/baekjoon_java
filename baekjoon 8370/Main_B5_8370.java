package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_8370 {
	static int n1, n2;
	static int k1, k2;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n1 = Integer.parseInt(st.nextToken());
		k1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		k2 = Integer.parseInt(st.nextToken());
		
		result = n1 * k1 + n2 * k2;
		System.out.println(result);
	}
}