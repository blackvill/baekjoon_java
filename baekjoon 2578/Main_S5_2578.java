package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_2578 {
	static int map[][] = new int[5][5];
	static int cnt;
	static int turn = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				// 해당 값 찾기
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						// 찾은 값을 0으로 만들기
						if (map[k][l] == n) {
							map[k][l] = 0;
						}
					}
				}
				
				col(); // 열
				row(); // 행
				diag1(); // 대각 1
				diag2(); // 대각 2
				
				// 3줄 빙고의 경우
				if (cnt >= 3) {
					// 턴 출력 후 종료
					System.out.println(turn);
					System.exit(0);
				}
				
				// 초기화
				cnt = 0;
				// 턴 증가
				turn++;
			}
		}
	}
	
	// 열 체크
	public static void col() {
		for (int i = 0; i < 5; i++) {
			int count = 0;
			
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == 0)
					count++;
				if (count == 5)
					cnt++;
			}
		}
	}
	
	// 행 체크
	public static void row() {
		for (int i = 0; i < 5; i++) {
			int count = 0;
			
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0)
					count++;
				if (count == 5)
					cnt++;
			}
		}
	}
	
	// 대각선 체크 (왼쪽 아래 > 오른쪽 위)
	public static void diag1() {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if (map[i][4 - i] == 0)
				count++;
			if (count == 5)
				cnt++;
		}
	}
	
	// 대각선 체크 (왼쪽 위 > 오른쪽 아래)
	public static void diag2() {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == 0)
				count++;
			if (count == 5)
				cnt++;
		}
	}
}