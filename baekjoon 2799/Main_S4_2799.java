package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S4_2799 {
	static int n, m;
	static char map[][];
	static int ans[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 5 * n + 1칸이 세로, 5 * m + 1칸이 가로
		n = Integer.parseInt(st.nextToken()) * 5 + 1;
		m = Integer.parseInt(st.nextToken()) * 5 + 1;
		
		ans = new int[5];
		map = new char[n][m];
		
		// 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 창문의 가로 탐색
		for (int i = 1; i < m; i += 5) {
			int cnt = 0; // 블라인드 칸수
			// 창문의 세로 탐색
			for (int j = 1; j < n; j++) {
				// 블라인드 벗어나면
				if (j % 5 == 0) {
					// 블라인드 칸수에 맞춰서 증가
					ans[cnt]++;
					cnt = 0; // 초기화
				}
				else {
					// 블라인드가 몇칸인지 세기
					if (map[j][i] == '*')
						cnt++;
				}
			}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
