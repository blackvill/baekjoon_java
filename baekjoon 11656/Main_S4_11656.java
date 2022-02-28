package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_11656 {
	static String s;
	static String[] str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        s = br.readLine();
 
        str = new String[s.length()]; // 배열 생성
        
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.substring(i); // 앞에서 부터 잘라서 접미사 배열에 넣기
        }
        
        // 접미사 배열 정렬하기
        Arrays.sort(str);
        
        for (int i = 0; i < str.length; i++) {
        	System.out.println(str[i]);
        }
    }
}