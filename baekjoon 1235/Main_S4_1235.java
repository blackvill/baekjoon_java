package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_S4_1235 {
	static int n;
	static String[] str;
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		str = new String[n];
		set = new HashSet<>();
		
		// 입력받기
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 0; i <= str[0].length(); i++) {
			int ck = 0; // 중복되지 않은 개수를 체크하기 위한 변수
			
			for (int j = 0; j < n; j++) {
				// 뒤에서부터 문자열 자르기
				String divide = str[j].substring(str[j].length() - i, str[j].length());
				
				// 자른 문자열이 없다면
				if (!set.contains(divide)) {
					// 셋에 넣어주기
					set.add(divide);
					ck++; // 개수 추가
				}
				else { // 이미 있다면
					ck = 0; // 0으로 초기화
					set = new HashSet<>(); // 셋을 초기화
					break;
				}
			}
			
			// 셋에 추가된 문자열의 개수가 n이라면 다 다르다는 것
			if (ck == n) {
				System.out.println(i);
				break;
			}
		}
	}
}
