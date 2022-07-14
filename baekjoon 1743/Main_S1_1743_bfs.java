package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_1743_bfs {
	static int n, m, k;
	static int[][] map;
	static boolean[][] visited;
	static int size;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	// 위치를 표시할 클래스
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
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		// 배열 채워주기
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 쓰레기의 위치
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			// 쓰레기 표시
			map[x][y] = 1;
		}
		
		// 쓰레기면서 방문한 적 없으면 bfs 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j])
					bfs(i, j);
			}
		}
		
		System.out.println(size);
	}
	
	public static void bfs(int x, int y) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(x, y));
		visited[x][y] = true; // 방문처리
		
		int cnt = 1; // 자기자신을 포함해야하니까 1로 초기화
		
		while (!q.isEmpty()) {
			point pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dr[i];
				int ny = pos.y + dc[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] != 1)
					continue;
				
				q.add(new point(nx, ny)); // 추가 탐색을 위한 큐 삽입
				visited[nx][ny] = true; // 방문 처리
				cnt++; // 쓰레기 크기 증가
			}
		}
		
		// 가장 큰 사이즈 찾기
		size = Math.max(size, cnt);
	}
}