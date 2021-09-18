package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B3_3028 {
	static int[] cup;
	static int temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cup = new int[] {1, 0, 0};
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == 'A') {
				temp = cup[0];
				cup[0] = cup[1];
				cup[1] = temp;
			}
			else if (c == 'B') {
				temp = cup[1];
				cup[1] = cup[2];
				cup[2] = temp;
			}
			else if (c == 'C') {
				temp = cup[0];
				cup[0] = cup[2];
				cup[2] = temp;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (cup[i] == 1) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}
