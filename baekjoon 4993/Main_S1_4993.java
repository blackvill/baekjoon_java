package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_4993 {
	static int n, m;
	static char map[][];
	static boolean visited[][];
	static int cnt;
	static int sx, sy;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static class point {
		int x;
		int y;
		
		public point (int x, int y) {
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
			
			// 종료 조건
			if (n == 0 && m == 0)
				break;
			
			map = new char[m][n];
			visited = new boolean[m][n];
			
			cnt = 0;
			
			for (int i = 0; i < m; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
					// 시작 위치 정하기
					if (map[i][j] == '@') {
						sx = i;
						sy = j;
					}
				}
			}
			
			cnt = 1;
			bfs(sx, sy);
			
			System.out.println(cnt);
		}
	}

	public static void bfs(int x, int y) {
		Queue<point> q = new LinkedList<point>();
		q.add(new point(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			point pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dr[i];
				int ny = pos.y + dc[i];
				
				// 범위 체크
				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				
				// 방문체크, 빨간칸 체크
				if (map[nx][ny] == '#' || visited[nx][ny])
					continue;
				
				cnt++; // 검은 칸 수 증가
				q.add(new point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
}
