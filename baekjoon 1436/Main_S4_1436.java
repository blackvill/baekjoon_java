package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S4_1436 {
	static int n;
	static int cnt = 1;
	static int num = 666; // 666이 1이므로 666부터 시작하면 됨
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		// cnt와 n이 같을때 num을 찾으면 되는 문제
		while (cnt < n) {
			num++;
			
			// 666이 포함되어 있으면
			if (String.valueOf(num).contains("666"))
				cnt++; // cnt를 증가
		}
		
		System.out.println(num);
	}
}
