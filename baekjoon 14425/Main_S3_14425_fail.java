package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S3_14425_fail {
	static int n;
	static int m;
	static String[] s;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		s = new String[n];
		
		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < n; j++) {
				if (s[j].compareTo(str) == 0)
					count++;
			}
		}
		
		System.out.println(count);
	}

}
