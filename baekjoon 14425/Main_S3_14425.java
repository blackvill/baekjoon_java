package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S3_14425 {
	static int n;
	static int m;
	static HashSet<String> set;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			if (set.contains(str))
				count++;
		}
		
		System.out.println(count);
	}

}
