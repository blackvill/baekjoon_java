package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S4_16499 {
	static int n;
	static char[] word;
	static HashSet<String> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		set = new HashSet<>(); // 만들어진 단어를 담아줄 해쉬셋
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine(); // 단어 입력받기
			word = str.toCharArray(); // 단어를 char단위로 잘라서 배열에 담아주기
			
			Arrays.sort(word); // 잘려서 담긴 단어들을 정렬해주기
			
			// 정렬 된 단어를 하나의 단어로 만들기
			String makeword = new String(word);

			// 해당 단어를 셋에 넣기
			set.add(makeword);
		}
		// 셋의 크기를 출력
		System.out.println(set.size());
	}
}