package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_14940 {
	static int n, m;
	static int map[][];
	static int sx, sy;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static class point {
		int x;
		int y;
		
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		// 값 입력받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 도착지점
				if (map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 0) // 갈 수 있는 곳
					sb.append(map[i][j] - 2 + " "); // 2를 빼주는 이유는 시작을 2로 시작하였기 때문
				else // 못가는 곳
					sb.append(0 + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<point> q = new LinkedList<>();
		// 도착지점을 시작으로 잡음
		q.offer(new point(sx, sy));
		map[sx][sy] = 2; 
		
		while (!q.isEmpty()) {
			point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dr[i];
				int ny = p.y + dc[i];
				
				// 범위를 벗어나거나 못가는 곳
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0)
					continue;
				
				// 갈 수 있는 곳이라면 이전 값 + 1
				if (map[nx][ny] == 1) {
					map[nx][ny] = map[p.x][p.y] + 1;
					q.offer(new point(nx, ny));
				}
			}
		}
 	}
}