package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S5_15233_김재욱 {
	static HashMap<String, String> map;
	static int a;
	static int b;
	static int g;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			String name = st.nextToken();
			
			map.put(name, "A");
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			String name = st.nextToken();
			
			map.put(name, "B");
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < g; i++) {
			String name = st.nextToken();
			
			if (map.get(name) == "A")
				cnt++;
		}
		
		if (cnt > g - cnt)
			System.out.println("A");
		else if (cnt < g - cnt)
			System.out.println("B");
		else if (cnt == g - cnt)
			System.out.println("TIE");
	}
}
