package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2_8958 {
	static int n;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			count = 0;
			String str = br.readLine();
			int o = 1;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					count += o;
					o++;
				}
				else if (str.charAt(j) == 'X')
					o = 1;
			}
			System.out.println(count);
		}
	}

}
