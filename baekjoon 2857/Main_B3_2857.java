package BOJ_bronze;

import java.io.*;

public class Main_B3_2857 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;

		for (int i = 1; i <= 5; i++) {
			String str = br.readLine();
			
			if (str.contains("FBI")) {
				System.out.print(i + " ");
				cnt++;
			}
		}
		
		if (cnt == 0)
			System.out.println("HE GOT AWAY!");
	}
}