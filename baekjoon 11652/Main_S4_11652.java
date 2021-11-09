package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_11652 {
	static int n;
	static long[] card;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		card = new long[n];

		// 입력받기
		for (int i = 0; i < n; i++) {
			card[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(card); // 정렬
		
		long check = card[0]; // 선택된 카드
		int count = 1; // 카드의 수
		int max = 1; // 최고값
		
		for (int i = 1; i < n; i++) {
			if (card[i] == card[i - 1]) { // 이전에 카드와 같은 카드라면
				count++; // 수를 증가
			}
			else { // 아니라면 1로 초기화
				count = 1;
			}
			
			if (count > max) { // max 값보다 카드의 수가 많으면
				max = count; // max값을 갱신해주기
				check = card[i]; // 선택 카드를 현재의 카드로 갱신해주기
			}
		}
		
		System.out.println(check);
	}

}
