package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576_김재욱 {
	public static int M, N;
	public static int map[][];
	public static boolean visit[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 익은 토마토가 있을 경우 큐에 추가
				if (map[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		bfs();
	}

	public static void bfs() {
		int result = 0;
		int x, y;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			x = cur[0];
			y = cur[1];
			visit[x][y] = true;
			// 네 방향으로 탐색
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				// 다음 행선지가 범위 안이면
				if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
					if (map[newX][newY] == 0) {  //안익은 토마토 발견
						queue.add(new int[] {newX, newY});
						visit[newX][newY] = true;
						map[newX][newY] = map[x][y] + 1;
						result = map[newX][newY];
					}
				}
			}
		}

		//안익은 토마토가 있으면 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.print(-1);
					return;
				}
			}
		}
		if (result > 0)
			result--;
		System.out.print(result);
	}
}