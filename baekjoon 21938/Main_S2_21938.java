package BOJ_silver;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S2_21938 {
	static int n, m, t;
	static int map[][];
	static boolean visited[][];
	static int cnt;
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		// 채우기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				// 평균을 내기 위한 r, g, b
				int r = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 위에서 받은 r, g, b의 평균값으로 map에 채움
				map[i][j] = (r + g + b) / 3;
			}
		}
		
		// 입력받기
		t = Integer.parseInt(br.readLine());
		
		// t 이상일 경우 255 아니면 0으로 채워주기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= t)
					map[i][j] = 255;
				else
					map[i][j] = 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 255거나 방문하지 않은곳이라면
				if (map[i][j] == 255 && !visited[i][j]) {
					// dfs 탐색
					dfs(i, j);
					// 구역 갯수 증가
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int x, int y) {
		// 해당 지역 방문 체크
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			// 범위를 벗어나면 continue
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			
			// 탐색가능한 곳이고 방문하지 않은 곳이라면
			if (map[nx][ny] != 0 && !visited[nx][ny])
				// 추가 탐색
				dfs(nx, ny);
		}
	}
}