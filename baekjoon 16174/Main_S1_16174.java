package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_16174 {
	static int n;
	static int map[][];
	static boolean visited[][];
	
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	
	// 위치 클래스
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
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		StringTokenizer st;
		
		// 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 탐색
		bfs(0, 0);
	}
	
	public static void bfs(int x, int y) {
		Queue<point> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new point(x, y));
		
		while (!q.isEmpty()) {
			point pos = q.poll();
			
			// 도착지점에 도달하면
			if (map[pos.x][pos.y] == -1) {
				System.out.println("HaruHaru"); // 출력
				return;
			}
				
			// 아래, 오른쪽 두 방향만 탐색
			for (int i = 0; i < 2; i++) {
				// map[pos.x][pos.y]을 곱하는 이유는 해당 칸의 숫자만큼 이동 가능
				int nx = pos.x + dr[i] * map[pos.x][pos.y];
				int ny = pos.y + dc[i] * map[pos.x][pos.y];
				
				// 범위를 벗어나거나 이미 탐색한 곳이라면
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				q.add(new point(nx, ny));
			}
		}
		
		// 도착지점 도달 불가
		System.out.println("Hing");
	}
}