package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14502 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] check;
	static int max;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
	}

	public static void dfs(int cnt) {
		// 벽을 3개 세웠을 때
		if (cnt == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void bfs() {
		check = new int[n][m];
		Queue<int[]> q = new LinkedList<int[]>();

		// 바이러스가 퍼진 상태의 map을 구현 하기 위해 map의 상태를 복사
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check[i][j] = map[i][j];
				if (check[i][j] == 2)
					q.offer(new int[] {i, j});
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) { // 4방탐색
				int nx = cur[0] + dr[i];
				int ny = cur[1] + dc[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (check[nx][ny] == 0) {
						check[nx][ny] = 2;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		// 안전 구역의 수를 세서 최고 값과 비교해 더 큰 값으로 변경해준다.
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}
}
