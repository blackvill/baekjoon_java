package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S1_1303 {
	static int n, m;
	static char[][] map; // 입력 배열
	static boolean[][] visited; // 방문처리 배열
	static int cnt; // 연결된 개수 체크용 변수
	static int w, b;
	
	// 사방탐색용 배열
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[m][n];
		visited = new boolean[m][n];
		
		// 입력받기
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 탐색하기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 갯수 초기화
				cnt = 1;
				// 처음 탐색한 경우
				if (!visited[i][j]) {
					// dfs 탐색
					dfs(map[i][j], i, j);
				
					// 해당 좌표가 W라면 w 증가, B라면 b 증가
					if (map[i][j] == 'W')
						w += cnt*cnt;
					else
						b += cnt*cnt;
				}
			}
		}
		
		System.out.println(w + " " + b);
	}
	
	public static void dfs(char ch, int r, int c) {
		// 방문 처리
		visited[r][c] = true;

		// 사방탐색
		for (int i = 0; i < 4; i++) {
			int nx = r + dr[i];
			int ny = c + dc[i];
			
			// 범위를 벗어나거나 이미 탐색한 경우
			if (nx >= m || nx < 0 || ny >= n || ny < 0 || visited[nx][ny])
				continue;
			
			// 시작하는 곳(W인지 B인지)과 다른 경우
			if (map[nx][ny] != ch)
				continue;
			
			// 갯수 증가
			cnt++;
			// 추가 탐색
			dfs(ch, nx, ny);
		}
	}
}
