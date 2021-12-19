package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_6550 {
	static String str;
	static int idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			// s1에서 체크할 위치를 가르킬 인덱스
			idx = 0;
			
			for (int i = 0; i < s2.length(); i++) {
				// 비교하면서 같으면
				if (s1.charAt(idx) == s2.charAt(i)) {
					idx++; // idx 증가
				}
				// 만약 idx가 s1의 길이라면 다 찾은거니까 탈출
				if (idx == s1.length())
					break;
			}
			
			// 상황에 맞춰 출력
			if (idx == s1.length())
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}