package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G4_5052 {
	static int t;
	static int n;
	static String number[]; // 전화번호
	static boolean consistency; // 일관성

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < t; T++) {
			n = Integer.parseInt(br.readLine());
			number = new String[n];
			consistency = false; // 일관성 체크
			
			for (int i = 0; i < n; i++) {
				number[i] = br.readLine();
			}
			
			// 정렬을 해서 접두어가 비슷한 것끼리 연결이 되도록 해준다.
			Arrays.sort(number);
			
			for (int i = 0; i < n - 1; i++) {
				if (number[i + 1].startsWith(number[i])) { // 접두어라면
					consistency = false; // 일관성 false
					break; // 바로 탈출
				} 
				else // 아니라면 true
					consistency = true;
			}
			
			if (consistency) // 일관성이 있다면
				System.out.println("YES");
			else // 없다면
				System.out.println("NO");
		}
	}
}
