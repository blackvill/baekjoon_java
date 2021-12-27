package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2_5598_김재욱 {
	static String word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		word = br.readLine();
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'D' && word.charAt(i) <= 'Z')
				System.out.print((char)(word.charAt(i) - 3));
			else
				System.out.print((char)(word.charAt(i) + 23));
		}
	}
}