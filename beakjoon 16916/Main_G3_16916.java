package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G3_16916 {
	static String p;
	static String s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		p = br.readLine();
		
		System.out.println(KMP(s, p));
		
	}
	
	// KMP 알고리즘
	static int KMP(String s, String p) {
		int[] prefix = new int[p.length()];
		
		int idx=0;
		
		// 접미사, 접두사 배열 생성
		for(int i = 1; i < p.length(); i++) {
			while(idx > 0 && p.charAt(i) != p.charAt(idx)) {
				idx = prefix[idx - 1];
			}
			
			if(p.charAt(i) == p.charAt(idx)) {
				idx += 1;
				prefix[i] = idx;  
			}
		}
		
		// 다시 초기화
		idx = 0;
		
		for(int i = 0; i < s.length(); i++) {
			// idx가 0보다 크고 s의 문자와 p의 문자가 다르면
			while(idx > 0 && s.charAt(i) != p.charAt(idx)) {
				idx = prefix[idx - 1]; // index이동
			}
			// 만약 같다면
			if(s.charAt(i) == p.charAt(idx)) {
				// p의 길이까지 된다면
				if(idx == p.length() - 1) {
					idx = prefix[idx];
					
					return 1;
				}
				// p의 길이가 되지 않으면
				else {
					// idx는 증가
					idx += 1;
				}
			}
		}
		
		return 0; // 매칭이 안되었으면 0 
	}
}