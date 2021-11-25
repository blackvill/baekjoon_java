package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_7795 {
	static int T;
	static int[] a;
	static int[] b;
	static int n;
	static int m;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			a = new int[n];
			b = new int[m];
			cnt = 0;
			
			// a 입력받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			// b 입력받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			int ap = n - 1;
			int bp = 0;
			
			while (ap >= 0) {
				if (a[ap] > b[bp]) {
					cnt++;
					bp++;
				}
				else if (a[ap] <= b[bp]) {
					bp = 0;
					ap--;
				}
				
				if (bp >= m) {
					bp = 0;
					ap--;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
