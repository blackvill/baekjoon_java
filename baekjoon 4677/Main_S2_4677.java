package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_4677 {
	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int ans;
	
	static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1}; 
	static int[] dc = {-1, 1, 0, 0, -1, -1, 1, 1}; 
	
	static class point{
		int x;
		int y;
		
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if (m == 0)
				break;
			
			map = new char[n][m];
			visited = new boolean[n][m];
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			ans = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '@' && !visited[i][j]) {
						bfs(i, j);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<point> q = new LinkedList<point>();
		q.add(new point(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			point pos = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int nx = pos.x + dr[i];
				int ny = pos.y + dc[i];
				
				// 범위 벗어나기
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				// 기름이 아니거나 이미 방문한 곳이면
				if (map[nx][ny] == '*' || visited[nx][ny])
					continue;
				
				q.add(new point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
}