package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_18243 {
	static int max = 10000;
	static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j)
					arr[i][j] = max; // 배열을 max 값으로 갱신
			}
		}
		
		for (int i = 0; i < k; i++) { // 관계를 0부터 시작으로 처리하기위해 -1
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		// 플루이드 와샬
		for (int t = 0; t < arr.length; t++) { // 경유지
			for (int i = 0; i < arr.length; i++) { // 출발지
				if (i == t) // 경유지 == 출발지면 탐색 불필요
					continue;
				
				for (int j = 0; j < arr.length; j++) { // 도착지
					// 경유지 == 도착지 or 출발지 == 도착지면 탐색 불필요
					if (i == j || t == j)
						continue;
					
					// 경유지를 거치는 경우 vs 바로 가는 경우 더 적은 것
					arr[i][j] = Math.min(arr[i][j], arr[i][t] + arr[t][j]);
				}
			}
		}
		
		// 결과 탐색
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 6번만에 도착이 되는지 탐색을 하는 것이므로 6보다 큰지 체크
				if (arr[i][j] > 6) {
					check = true; // 큰 세상
					break;
				}
			}
			
			if (check)
				break;
		}
		
		// 큰 세상이면 Big World! 출력
		if (check)
			System.out.println("Big World!");
		// 아니면 Small World 출력
		else
			System.out.println("Small World!");
	}
}