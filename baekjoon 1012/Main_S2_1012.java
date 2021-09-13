package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1012 {
	static int n;
	static int m;
	static int k;
	static int testcase;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testcase = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[m][n];
			visited = new boolean[m][n];
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			int count = 0;
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1 && visited[i][j] != true) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (0 <= nx && 0 <= ny && nx < m && ny < n) {
				if (map[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}
}