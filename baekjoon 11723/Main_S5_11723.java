package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_11723 {
	static int M;
	static String str;
	static int x;
	static int ans;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			link(str);
		}

		System.out.println(sb.toString());
	}
	
	public static void link(String str) {
		switch(str) {
		case "add":
			x = Integer.parseInt(st.nextToken());
			ans |= (1 << (x - 1));
			break;
		case "remove":
			x = Integer.parseInt(st.nextToken());
			ans = ans & ~(1 << (x - 1));
			break;
		case "check":
			x = Integer.parseInt(st.nextToken());
			sb.append(((ans & (1 << (x - 1))) != 0 ? 1 : 0) + "\n");
			break;
		case "toggle":
			x = Integer.parseInt(st.nextToken());
			ans ^= (1 << (x-1));
			break;
		case "all":
			ans |= (~0);
			break;
		case "empty":
			ans &= 0;
			break;
		}
	}
}