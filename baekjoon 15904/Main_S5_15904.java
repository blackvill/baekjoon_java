package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_15904 {
	static char ucpc[] = {'U', 'C', 'P', 'C'};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sentence = br.readLine();
		
		int index = 0;
		
		// 문장을 비교하면서 ucpc가 있는지 체크
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ucpc[index])
				index++;
			if (index == 4) // 이미 UCPC가 다 포함되었다면 더 이상 탐색할 필요가 없다.
				break;
		}
		
		if (index == 4) { // 만약 index가 4라면(UCPC가 다 포함되었다면)
			System.out.println("I love UCPC");
		}
		else
			System.out.println("I hate UCPC");
	}
}