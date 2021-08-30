package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_10156 {

	static int k; // 과자 1개의 가격
	static int n; // 과자의 갯수
	static int m; // 가지고 있는 돈

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int cookie = k * n;
		if (cookie <= m)
			System.out.println("0");
		else
			System.out.println(cookie - m);
	}

}
