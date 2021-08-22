package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_10163 {
	static int n;
	static int[][] map;
	static int[] count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[1001][1001];
		count = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			
			for (int r = y; r < y + col; r++) {
				for (int c = x; c < x + row; c++) {
					map[r][c] = i;
				}
			}
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				count[map[i][j]]++; 
			}
		}
		for (int i = 1; i <= n; i++)
			System.out.println(count[i]);
	}
}
