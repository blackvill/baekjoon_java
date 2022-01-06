package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S5_11536 {
	static int n;
	static String[] str; // 입력받은 이름
	static String[] sorting_str; // 이름들을 정렬하기 위한 추가 배열
	static boolean inc = false; // 오름차순 체크
	static boolean decs = false; // 내림차순 체크

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		str = new String[n];
		sorting_str = new String[n];
		
		// 이름 입력받기
		for (int i = 0; i < n; i++) {
			sorting_str[i] = str[i] = br.readLine();
		}
		
		// 정렬
		Arrays.sort(sorting_str);
		
		// 오름차순 체크
		for (int i = 0; i < n; i++) {
			if (sorting_str[i] == str[i])
				inc = true;
			else { // 중간에 오름차순이 아니라면 false후 탈출
				inc = false;
				break;
			}
		}
		
		// for문을 다 돌았는데 오름차순이라면 결과 출력 후 종료
		if (inc == true) {
			System.out.println("INCREASING");
			System.exit(0);
		}
		
		// 내림차순 체크
		for (int i = 0; i < n; i++) {
			if (sorting_str[n - 1 - i] == str[i])
				decs = true;
			else { // 중간에 내림차순이 아니라면 false후 탈출
				decs = false;
				break;
			}
		}
		
		// for문을 다 돌았는데 내림차순 이라면 결과 출력 후 종료
		if (decs == true) {
			System.out.println("DECREASING");
			System.exit(0);
		}
		
		// 위에서 종료되지 않고 왔다면 오름차순, 내림차순 둘 다 아니란 뜻이므로
		// NEITHER 출력
		System.out.println("NEITHER");
	}
}