package BOJ_silver;

import java.io.*;

public class Main_S1_2002 {
	static int n;
	static String[] enter;
	static String[] outer;
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		enter = new String[n];
		outer = new String[n];
		check = new boolean[n];
		
		// 입구로 들어간 순서
		for (int i = 0; i < n; i++) {
			enter[i] = br.readLine();
		}
		
		// 출구로 나온 순서
		for (int i = 0; i < n; i++) {
			outer[i] = br.readLine();
		}
		
		// 추월 차량의 개수 찾기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 자신과 만나기 전에 나오는 차들은 자신을 추월했다는 것임
				// 자신과 다른 차량번호라면
				if (!enter[i].equals(outer[j])) {
					// 검사하지 않은 경우
					if (check[j] == false) {
						check[j] = true;
						cnt++; // 카운트 증가
					}
				}
				// 같은 번호라면
				else {
					// 검사 체크하고
					check[j] = true;
					// 탈출
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}