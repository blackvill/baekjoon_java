package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_S1_16500 {
	static int n;
	static String s;
	static int[] dp = new int[101];
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        n = Integer.parseInt(br.readLine());

        // 포함되는 단어인지 체크하기 위한 단어들 입력받기
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(dp[j] == 1) {
                	// 자른 문자열이 set에 포함되어 있다면 
                    if(set.contains(s.substring(i, j)))
                    	dp[i] = 1; // 1로 변경
                }
            }
            // 자르고 남은 부분 문자가 포함되어 있으면 1
            if(set.contains(s.substring(i)))
            	dp[i] = 1;
        }
        
        System.out.println(dp[0]);
    }
}