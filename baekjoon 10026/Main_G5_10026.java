package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_10026 {
	static int n;
	static char[][] map;
	static char[][] RG_map;
	static boolean[][] visited;
	static int count;
	static int count_RG;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		RG_map = new char[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
				RG_map[i][j] = str.charAt(j) == 'G' ? 'R' : str.charAt(j);
			}
		}
		// 일반인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false) {
					dfs(i, j, map);
					count++;
				}
			}
		}
		visited = new boolean[n][n];
		// 적록색약
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false) {
					dfs(i, j, RG_map);
					count_RG++;
				}
			}
		}
		System.out.println(count + " " + count_RG);
	}
	
	public static void dfs(int x, int y, char arr[][]) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (0 <= nx && 0 <= ny && nx < n && ny < n) {
				if (arr[nx][ny] == arr[x][y] && visited[nx][ny] == false) {
					dfs(nx, ny, arr);
				}
			}
		}
	}
}
