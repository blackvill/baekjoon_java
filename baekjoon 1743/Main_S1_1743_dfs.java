package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_1743_dfs {
	static int n, m, k;
	static int[][] map;
	static boolean[][] visited;
	static int size, cnt;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 쓰레기 좌표
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			// 쓰레기 표시
			map[x][y] = 1;
		}
		
		// 쓰레기고 방문한적 없으면 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 0; // 개수 초기화
					dfs(i, j); // dfs 탐색
					size = Math.max(size, cnt); // 더 큰 사이즈 구하기
				}
			}
		}
		
		System.out.println(size);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true; // 방문처리
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] != 1)
				continue;
			
			dfs(nx, ny); // 추가 탐색
		}
		
	}
}