package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_1254 {
	static String s;
	static int len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();
        
        for (int i = 0; i < s.length(); i++) {
        	// 구간을 잘라서 펠린드롬인지 아닌지 확인
            if (Palindrome(s.substring(i))) {
                break; // 펠린드롬이면 탈출
            }
            len++;
        }
        System.out.println(len);
    }

	// 펠린드롬인지 확인
    static boolean Palindrome(String s) {
        int start = 0; // 시작
        int end = s.length() - 1; // 끝
        
        while (start <= end) {
        	// 다르면
        	if (s.charAt(start) != s.charAt(end))
        		return false; // 펠린드롬이 아님
        	start++;
        	end--;
        }
        
        return true; // 끝까지 탐색이 되면 펠린드롬
    }
}