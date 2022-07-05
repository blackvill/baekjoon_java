package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_1531 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받기
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 그림을 표현하기 위한 map배열
		int[][] map = new int[101][101];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 4개의 좌표 입력받기
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 좌표의 영역을 1씩 증가
			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					map[j][k]++;
				}
			}
		}
		
		int cnt = 0;
		// 그림을 탐색하면서 m보다 큰 값이 있으면 해당 역역은 가려진 곳
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] > m)
					cnt++;
			}
		}
		
		// 가려진 곳의 개수 세기
		System.out.println(cnt);
	}
}