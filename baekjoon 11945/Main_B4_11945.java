package BOJ_bronze;

import java.io.*;
import java.util.*;

public class Main_B4_11945 {
	static int n, m;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}