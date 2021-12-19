package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_1439 {
	static int cnt = 1; // 문자가 변경되는 횟수, 처음에 무조건 나오니까 1
	static char check; // 문자가 변경되는지 체크할 문자
	static String str; // 입력받을 문자열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 입력받기
		str = br.readLine();
		// 맨 처음 문자를 비교한 문자로 두기
		check = str.charAt(0);
		
		for (int i = 1; i < str.length(); i++) {
			// 문자가 다르면 cnt 증가시키고 비교 문자를 현재 문자로 변경
			if (str.charAt(i) != check) {
				check = str.charAt(i);
				cnt++;
			}
		}
		
		// cnt / 2가 바꿔야 하는 최소 횟수
		System.out.println(cnt / 2);
	}
}