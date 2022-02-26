package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_20254 {
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans += Integer.parseInt(st.nextToken()) * 56;
		ans += Integer.parseInt(st.nextToken()) * 24;
		ans += Integer.parseInt(st.nextToken()) * 14;
		ans += Integer.parseInt(st.nextToken()) * 6;
		
		System.out.println(ans);
	}
}