package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_9996 {
	static String start;
	static String end;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// *을 기준으로 문자열을 자르기
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		
		start = st.nextToken(); // 시작
		end = st.nextToken(); // 끝
		
		// 문자열 입력받기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			
			// 만약 글자수가 적다면 절대 붏가능이니까 NE
			if (str.length() < start.length() + end.length())
				System.out.println("NE");
			// 길이가 긴 상태에서 start로 시작하고 end로 끝난다면
			else if (str.startsWith(start) && str.endsWith(end))
				System.out.println("DA");
			else // 길이가 긴 상태에서 start로 시작하고 end로 끝나지 않는다면
				System.out.println("NE");
		}
	}
}