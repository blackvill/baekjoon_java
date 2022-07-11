package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_1926 {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int cnt;
	static int area;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					cnt = 1;
					visited[i][j] = true;
					dfs(i, j);
					area++;
				}
			}
		}
		
		System.out.println(area + "\n" + max);
	}
	
	public static void dfs(int x, int y) {			
		max = Math.max(cnt, max);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
				continue;
			}
			
			cnt++;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}