package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_4375_김재욱 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
		while ((str = br.readLine()) != null) {
			n = Integer.parseInt(str);
			
			int cnt = 1;
			int temp = 1;
			
			while (true) {
				if (temp % n == 0)
					break;
				
				cnt++;
				
				temp = (temp * 10 + 1) % n;
			}
			
			System.out.println(cnt);
		}
	}
}