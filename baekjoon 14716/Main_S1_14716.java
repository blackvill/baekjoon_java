package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_14716 {
	static int m, n;
	static int map[][];
	static boolean visited[][];
	static int cnt;
	
	static int dr[] = {0, 0, -1, -1, -1, 1, 1, 1};
	static int dc[] = {-1, 1, 0, -1, 1, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new boolean[m][n];
		
		// 입력받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 글자이면서 미방문이면
				if (map[i][j] == 1 && !visited[i][j]) {
					// dfs 탐색
					dfs(i, j);
					// 문자 수 증가
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		// 팔방탐색
		for (int i = 0; i < 8; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			// 범위 안, 미방문, 문자일 경우
			if ((nx >= 0 && ny >= 0 && nx < m && ny < n) && !visited[nx][ny] && map[nx][ny] == 1) {
				// 방문처리
				visited[nx][ny] = true;
				// 추가 dfs 탐색
				dfs(nx, ny);
			}
		}
	}
}