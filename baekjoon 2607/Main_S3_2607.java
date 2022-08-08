package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_2607 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫번째 문자열은 기준 문자열이므로 1개 제거 
        int n = Integer.parseInt(br.readLine()) - 1;
        
        // 기준이 될 문자열
        String str = br.readLine();
        int len = str.length(); // 문자열의 길이
        
        int[] alpha = new int[26];
        
        // 각 자리의 알파벳 값을 배열로 증가하기
        for (int i = 0; i < len; i++) {
            alpha[str.charAt(i) - 'A']++;
        }
        
        int ans = 0;
        
        for (int k = 0; k < n; k++) {
        	// 기준의 문자열의 알파벳값들을 복제
            int[] clone = alpha.clone();
            // 비교할 문자열
            String comp = br.readLine();
            int cnt = 0;
            
            for (int i = 0; i < comp.length(); i++) {
            	// 비교 문자열의 각 자리값들을 보면서 clone에 값을 빼주기
                if (clone[comp.charAt(i) - 'A'] > 0) {
                    clone[comp.charAt(i) - 'A']--;
                    cnt++;
                }
            }
            
            // 길이가 1글자 더 적을 때, 지운 문자열의 수와 비교하는 문자열과 같을때
            if (len - 1 == comp.length() && cnt == comp.length()) {
                ans++;
            }
            // 길이가 비교하는 문자와 같을 때
            else if (len == comp.length()) {
                if (cnt == len || cnt == len - 1)
                	ans++;
            }
            // 길이가 1글자 더 많을 때, 비교하는 문자열과 지운 문자열의 수가 같을 때
            else if (len + 1 == comp.length() && cnt == len) {
               	ans++;
            }
        }
        
        System.out.println(ans);
	}
}