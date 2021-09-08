package BOJ_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S4_10816 {
	static int n;
	static String[] split;
	static Map<Integer, Integer> card;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		card = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(card.containsKey(number)){
				card.replace(number, card.get(number) + 1);
			} else { 
				card.put(number, 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (card.containsKey(number)) { // 키값이 있으면
				sb.append(card.get(number) + " "); // 키의 value를 출력
			} else {
				sb.append("0 "); // 없으면 0
			}
		}
		System.out.println(sb);
	}
}