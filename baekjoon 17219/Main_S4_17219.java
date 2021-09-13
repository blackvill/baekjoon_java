package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_17219 {
	static int n;
	static int m;
	static HashMap<String, String> map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new HashMap<String, String>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String site = st.nextToken();
			String pw = st.nextToken();
			
			map.put(site, pw);
		}
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			System.out.println(map.get(str));
		}
	}
}