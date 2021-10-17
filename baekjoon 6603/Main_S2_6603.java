package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_6603 {
	static int k; // 전체 원소의 개수
	static int[] s; // 전체 원소
	static boolean[] n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			
			if (k == 0)
				break;
			
			s = new int[k];
			n = new boolean[k];
			
			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			System.out.println();
		}
	}
	
	public static void comb(int st, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < k; i++) {
				if (n[i]) {
					System.out.print(s[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		for (int i = st; i < k; i++) {
			n[i] = true;
			comb(i + 1, cnt + 1);
			n[i] = false;
		}
	}
}
