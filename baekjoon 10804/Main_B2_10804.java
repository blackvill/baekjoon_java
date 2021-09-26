package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_10804 {
	static int[] card;
	static int[] card_re;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		card = new int[21];
		card_re = new int[21];
		
		make();
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			reverse(s, e);
		}
		
		print_card();
	}
	
	public static void make() {
		for (int i = 0; i < 21; i++) {
			card[i] = i;
		}
	}

	public static void reverse(int start, int end) {
		int e = end;
		for (int i = 0; i < 21; i++) {
			if (i >= start && i <= end) {
				card_re[i] = card[e];
				e--;
			}
			else
				card_re[i] = card[i];
		}
		
		for (int i = 0; i < 21; i++) {
			card[i] = card_re[i];
		}
	}
	
	public static void print_card() {
		for (int i = 1; i < 21; i++) {
			System.out.print(card[i] + " ");
		}
		System.out.println();
	}
}