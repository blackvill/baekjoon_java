package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S5_2204 {
	static int n;
	static String list[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			
			// 0을 입력받으면 종료
			if (n == 0)
				break;
			
			// 초기화
			list = new String[n];
			
			// 입력받기
			for (int i = 0; i < n; i++) {
				list[i] = br.readLine();
			}
			
			// 대소문자 구분 없이 정렬 => String.CASE_INSENSITIVE_ORDER
			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
			
			System.out.println(list[0]);
		}
	}
}