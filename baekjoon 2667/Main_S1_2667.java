package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_2667 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] count = new int[1000];
	static int cnt;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		// 오름차순 정렬
		Arrays.sort(count);
		// 출력
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				continue;
			System.out.println(count[i]);
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		count[cnt]++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (map[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}
}
