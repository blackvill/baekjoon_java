package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_1013 {
	static int T;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 주어진 정규식
        String regular = "(100+1+|01)+";
        
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            
            // matches()는 인자로 정규표현식을 받습니다. 그리고 문자열과 패턴이 일치하는 지를 리턴합니다.
            // 맞다면 true, 다르다면 false
            if(str.matches(regular))
            	System.out.println("YES");
            else
            	System.out.println("NO");
        }
    }
}
