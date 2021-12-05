package BOJ_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_S5_1251 {
	static ArrayList<String> list = new ArrayList<>();
	static String str;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		String[] st = new String[3];

		for(int i = 1; i < str.length() - 1; ++i) {
			for(int j = i + 1; j < str.length(); ++j) {
				// 서브스트링을 사용해 3부분으로 문자열 쪼개기
				st[0] = str.substring(0, i);
				st[1] = str.substring(i, j);
				st[2] = str.substring(j, str.length());

				StringBuffer sb = new StringBuffer();

				// 쪼개진 문자열을 부분부분 뒤집기
				for(int k = 0; k < 3; ++k){
					for(int l = st[k].length() - 1; l >= 0; --l){
						sb.append(Character.toString(st[k].charAt(l)));
					}
				}
				
				// 문자열을 list에 추가하기
				list.add(sb.toString());
				
				sb.setLength(0);
			}    
		}

		Collections.sort(list); //정렬

		// 정렬되었으면 0번에 있는게 사전순으로 제일 앞에 있는 것이니까 이를 출력
		System.out.println(list.get(0));
	}
}