package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_1913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[] dx = {1, 0, -1, 0}; 
		int[] dy = {0, 1, 0, -1};
		int[][] arr = new int[n][n];
		int print_x = 0, print_y = 0;

		if (n == 1) {
			sb.append("1");
		}
		int x = -1;
		int y = 0;
		int count = 0;
		// 주요 소스코드
		for (int i = (n * n); i > 0; i--) {
			x += dx[count];
			y += dy[count];
			arr[x][y] = i;
			if ((y >= n - 1 && x >= n -1) || (y >= n - 1 && x == 0) || (x >= n - 1 && y == 0)) {
				count++;
				if (count == 4)
					count = 0;
			}
			if (arr[x + dx[count]][y + dy[count]] != 0) {
				count++;
				if (count == 4)
					count = 0;
			}
			
		}
		// 출력문
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]).append(" ");
				if (arr[i][j] == num) {
					print_x = i + 1;
					print_y = j + 1;
				}
			}
			sb.append("\n");
		}
		sb.append(print_x).append(" ").append(print_y);
		System.out.println(sb);
	}
}