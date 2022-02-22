package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2206 {
	static int n;
	static int m;
	
	static char[][] map;
	static int[][] dist;
	static boolean[][][] visited;
	
	static Queue<int[]> q = new LinkedList<>();

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		dist = new int[n][m];
		visited = new boolean[2][n][m]; // 벽을 부순지 안부순지 체크

		// 시작 == 종료
		// 바로 종료
		if (n - 1 == 0 && m - 1 == 0) { 
			System.out.print(1);
			System.exit(0);
		}

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		// x, y, 벽 부순 횟수
		q.offer(new int[] {0, 0, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			// 사방탐색
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				// 범위 벗어나느 경우
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (map[nx][ny] == '1') {	// 벽인 경우
					// 벽을 부순적 없고 방문한 적 없는 경우
					if (cur[2] == 0 && !visited[1][nx][ny]) {
						visited[cur[2]][nx][ny] = true; // 방문
						dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // 거리 측정
						q.offer(new int[] {nx, ny, 1}); // 해당 위치를 추가 탐색
					}
				}
				else{ // 벽이 아닐 경우
					if (!visited[cur[2]][nx][ny]) { // 해당 칸을 방문을 안했을 때
						visited[cur[2]][nx][ny] = true; // 방문
						dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // 거리 측정
						q.offer(new int[] {nx, ny, cur[2]}); // 해당 위치를 추가 탐색
					}
				}
				
				if (nx == n - 1 && ny == m - 1) {
					System.out.print(dist[nx][ny] + 1);
					System.exit(0);
				}
			}
		}
		// 불가능한 경우 -1 출력
		System.out.print(-1);
	}
}