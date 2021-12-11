package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S4_1543_김재욱 {
	static String str; // 문장
	static String pattern; // 찾을 패턴
	static int cnt; // 나오는 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		pattern = br.readLine();
		
		// pattern문자열과 길이가 같아야만 의미가 있으니 최소 문자열 - 패턴 안에 와야 함
		for(int i = 0; i <= str.length() - pattern.length(); i++) {
			boolean check = true;	// 문자가 동일한지 판단
			
			for(int j = 0; j < pattern.length(); j++) {
				// 검색하려는 단어가  중간에 다를 경우
				if(str.charAt(i + j) != pattern.charAt(j)) {
					check = false;
					break;
				}
			}
			
			// 만약 check가 true라면 
			if(check) {
				cnt++;	
				i += pattern.length() - 1;
			}
		}
		
		System.out.println(cnt);
	}
}