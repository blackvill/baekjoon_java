package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_11507 {
	static String str; // 입력받은 문자열
	static char c; // 카드 모양 (char형 => 입력받을 때 사용)
	static int num; // 카드의 번호
	static int shape; // 카드의 모양
	static boolean card[][] = new boolean[4][14];
	static int cnt[] = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		// 한줄로 문자열이 쭉 나열되서 입력이 된다.
		// 이는 알파벳(카드모양)숫자1숫자2라는 규칙으로 나열되어있기 때문에
		// 3씩 증가시켜서 처리해준다.
		for (int i = 0; i < str.length(); i += 3) {
			// 맨 처음은 알파벳
			c = str.charAt(i);
			// 그 다음 두 자리는 숫자 1, 숫자 2
			num = (str.charAt(i + 1) - '0') * 10 + (str.charAt(i + 2) - '0');
			
			// 알파벳에 따라서 번호를 주어준다.
			// 출력을 P,K,H,T순으로 해줘야 하기 때문에
			// 이 순서대로 번호를 주었다.
			switch (c) {
			case 'P':
				shape = 0;
				break;
			case 'K':
				shape = 1;
				break;
			case 'H':
				shape = 2;
				break;
			case 'T':
				shape = 3;
				break;
			}
			
			// 카드가 이미 있는 것이라면 출력 후 바로 종료
			if (card[shape][num]) {
				System.out.println("GRESKA");
				System.exit(0);
			}
			// 카드가 없다면 입력받았으니 있다고 변경
			card[shape][num] = true;
			// 해당 모양의 개수를 증가
			cnt[shape]++;
		}
		
		// 모양에 따른 갯수는 최대 13개이다.
		// 그러므로 13 - 해당 모양의 개수를 빼주면 필요한 카드의 개수가 된다.
		for (int i = 0; i < 4; i++) {
			System.out.print(13 - cnt[i] + " ");
		}
	}
}
