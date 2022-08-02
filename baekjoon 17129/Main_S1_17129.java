package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_17129 {
	static int n, m;
	static int map[][];
	static boolean visited[][];
	static int result = Integer.MAX_VALUE;
	
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	
	static Queue<point> q = new LinkedList<>();
	
	static class point{
		int x;
		int y;
		int move;
		
		public point(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				
				// 시작 위치
				if (map[i][j] == 2)
					q.offer(new point(i, j, 0));
			}
		}

		bfs();
	}

	static void bfs() {
		while(!q.isEmpty()) {
			point pos = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = pos.x + dr[i];
				int ny = pos.y + dc[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 1)
					continue;
				
				if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
					result = pos.move + 1;
					
					System.out.println("TAK");
					System.out.println(result);
					
					return;
				}
				
				visited[nx][ny] = true;
				q.offer(new point(nx, ny, pos.move + 1));
			}
		}
		
		System.out.println("NIE");
	}
}