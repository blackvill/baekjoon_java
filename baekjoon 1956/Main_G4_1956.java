package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1956 {
	static int v;
	static int e;
	static int[][] map;
	static int max = 100000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		map = new int[v + 1][v + 1];
		
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i == j)
					continue;
				else
					map[i][j] = max;
			}
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			map[start][end] = length;
		}
		
		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= v; j++) {
					if (j == i || j == k)
						continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i == j)
					continue;
				if (map[i][j] != max && map[j][i] != max)
					min = Math.min(min, map[i][j] + map[j][i]);
			}
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
}