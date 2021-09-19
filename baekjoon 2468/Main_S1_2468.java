package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2468 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int count;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]); // 최고 높이
				min = Math.min(min, map[i][j]); // 최저 높이
			}
		}
		
		int result = 1; // 모두 높이가 같은 경우라도 최소 1개
		for(int i = min; i < max; i++) { // 최소 ~ 최대 탐색
			count = 0;
			visited = new boolean[n][n];			
			
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					if(!visited[x][y] && map[x][y] > i) { 
						dfs(x, y, i);
						count++;
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}

	private static void dfs(int x, int y, int height) {
		if (x < 0 || x >= n || y < 0 || y >= n) {
			return;
		}
		
		if (visited[x][y] || map[x][y] <= height) {
			return;
		}
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			dfs(nx, ny, height);
		}
	}
}