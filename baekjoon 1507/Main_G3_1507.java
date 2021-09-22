package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_1507 {
	static int n;
	static int[][] map;
	static boolean[][] check;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		check = new boolean[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					check[i][j] = true;
				else {
					for (int k = 1; k <= n; k++) {
						if (k != i && k != j) {
							if(map[i][k] + map[k][j] < map[i][j]) {
								System.out.println(-1);
								return;
							}
							if (map[i][k] + map[k][j] == map[i][j])
								check[i][j] = true;
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (!check[i][j])
					result += map[i][j];
			}
		}
		
		System.out.println(result/2);
	}
}