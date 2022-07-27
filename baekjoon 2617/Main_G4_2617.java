package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G4_2617 {
	static int n, m;
	static int[][] arr;
	static int mid, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1][n + 1];
		
		// 값을 입력받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1; // 큰 구슬은 1
			arr[b][a] = -1; // 작은 구슬은 -1
		}
		
		for (int i = 1; i <= n; i++) { // 경유지
			for (int j = 1; j <= n; j++) { // 출발지
				// 자기 자신의 경우 탐색할 필요 없음
				if (i == j)
					continue;
				
				for (int k = 1; k <= n; k++) { // 도착지
					// 같은 경우 탐색할 필요가 없음
					if (i == k || k == j)
						continue;
					
					// 출발>경유, 경유>도착의 크기가 같고 도착>시작의 크기가 0이 아닌 경우 
					if (arr[k][i] != 0 && arr[j][i] == arr[i][k])
						arr[j][k] = arr[j][i]; // 출발>도착 = 출발 >경유
				}
			}
		}
		
		int[] bigger = new int[n + 1];
		int[] smaller = new int[n + 1];
		
		// 기준 구슬보다 작아야하는 갯수, 커야하는 갯수를 구하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 큰 구슬인 경우
				if (arr[i][j] == 1)
					bigger[i]++;
				// 작은 구슬인  경우
				if (arr[i][j] == -1)
					smaller[i]++;
			}
		}
		
		// 중간값
		mid = (n / 2) + 1;
		
		// 중간값보다 많은 경우 중간값이 될 수 없으므로 정답수 증가
		for (int i = 1; i <= n; i++) {
			//중간값보다 많은 경우
			if (bigger[i] >= mid)
				ans++;
			// 중간값보다 많은 경우 
			if (smaller[i] >= mid)
				ans++;
		}
		
		System.out.println(ans);
	}
}