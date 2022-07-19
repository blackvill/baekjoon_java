package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_21736 {
	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int dx, dy;
	static int cnt;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	// 위치를 나타낼 point 클래스
	static class point{
		int x;
		int y;
		
		public point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		// 입력받기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				
				// 도연이의 위치 저장
				if (map[i][j] == 'I') {
					dx = i;
					dy = j;
				}
			}
		}
		
		// 도연이의 위치에서 bfs 탐색
		bfs(dx, dy);
		
		// 만난 사람의 수가 0이면 TT 아니면 만난 사람의 수 출력
		if (cnt != 0)
			System.out.println(cnt);
		else
			System.out.println("TT");
	}
	
	public static void bfs(int x, int y) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			point pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dr[i];
				int ny = pos.y + dc[i];
				
				// 범위, 방문, 벽인 경우
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 'X')
					continue;
				
				// 사람을 만났으면
				if (map[nx][ny] == 'P')
					cnt++; // 만난 사람 수 증가
				
				// 방문처리
				visited[nx][ny] = true;
				// 추가 탐색
				q.add(new point(nx, ny));
			}
		}
	}
}