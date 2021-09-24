package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_S1_2447 {
	static char[][] map;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];

		star(0, 0, n, 0);
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void star(int x, int y, int n, int mode) {
		// 공백 칸
		if (mode == 1) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}

		if (n == 1) {
			map[x][y] = '*';
			return;
		}

		devide(x, y, n);
	}
	
	public static void devide(int x, int y, int n) {
		int size = n / 3;
		int cnt = 0;
		
		for (int i = x; i < x + n; i += size) {
			for (int j = y; j < y + n; j += size) {
				cnt++;
				
				if (cnt == 5) {
					star(i, j, size, 1);
				} else {
					star(i, j, size, 0);
				}
			}
		}
	}
}