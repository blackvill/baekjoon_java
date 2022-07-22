package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G2_1103 {
	static int n, m;
	static char[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int ans;
	static boolean inf;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		// 값 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		inf = false; // 무한루프 확인용 플래그
		visited[0][0] = true; // 시작지점 방문처리
		// 시작점에서 이동횟수 1로 잡고 시작
		dfs(0, 0, 1);
		
		// 결과 출력
		if (!inf)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
	
	public static void dfs(int x, int y, int move) {
		// 최고값 갱신
		ans = Math.max(ans, move);
		// 현재 위치를 지금까지 이동 횟수로 저장
		dp[x][y] = move;
		
		// 현재 위치값을 숫자로 변환
		int k = Integer.parseInt(map[x][y] + "");
		
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + (k * dr[i]);
			int ny = y + (k * dc[i]);
			
			// 범위를 벗어나거나 구멍인 곳
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'H') {
				continue;
			}
			
			// 이미 방문한 곳에 도착이 가능하면 무한번 이동 가능
			if (visited[nx][ny]) {
				inf = true; // -1 출력하고 종료
				return;
			}
			
			// 도착한 지점이 이미 이전에 저장된 횟수보다 많으면 탐색을 할 필요가 없음
			if (dp[nx][ny] > move)
				continue;
			
			// 방문 처리
			visited[nx][ny] = true;
			// 이동횟수를 증가시키고 추가 탐색
			dfs(nx, ny, move + 1);
			// 다른 방향 탐색에서 문제가 되지 않도록 다시 방문 처리 제거
			visited[nx][ny] = false;
		}
	}
}