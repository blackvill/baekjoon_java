package BOJ_bronze;

import java.io.*;
import java.util.*;

public class Main_B3_2506 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        int ans = 0; //총 점수
        int score = 0; //문제 맞을 때 더할 점수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num == 1) {
                score++; //더할 점수를 1씩 증가시켜준다
                ans += score;
            } else {
                score = 0; //문제를 틀리면 score는 리셋
            }
        }
        
        System.out.print(ans);
	}
}