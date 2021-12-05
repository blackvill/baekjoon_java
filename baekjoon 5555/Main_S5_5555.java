package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S5_5555 {
	static String str; // 찾고자 하는 문자열
	static int n; // 반지의 수
	static int cnt; // str이 새겨진 반지의 수
	static String ring; // 반지에 새겨진 문자열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			ring = br.readLine();
			String st = ring.substring(0, ring.length() - 1);
			
			ring += st; // 반지에 새겨진 글 뒤에 추가로 합치기
			
			if (ring.contains(str)) // 포함되어있다면 증가
				cnt++;
		}
		
		// 출력
		System.out.println(cnt);
	}
}