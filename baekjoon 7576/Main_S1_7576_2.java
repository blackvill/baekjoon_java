package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576_2 {
	static int n;
	static int m;
	static int result;
	static int map[][];
	static boolean visited[][];
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 익은 토마토가 있을 경우 큐에 추가
				if (map[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		//안익은 토마토가 있는지 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) { // 안익은 토마토가 있으면
					System.out.println("-1"); // -1 출력
					return;
				}
			}
		}
		// 처음에 1부터 시작해서 값을 올렸기 때문에 -1을 해줘야한다.
		// 증가를 했어야만 result의 값이 변화가 있으므로
		// 1 -1
		// -1 1
		// 과 같은 배열의 경우에는 -1을 해주지 않아야한다.
		if (result == 0)
			System.out.println(result);
		else
			System.out.println(result - 1);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int x = cur[0];
			int y = cur[1];
			visited[x][y] = true;
			
			// 네 방향으로 탐색
			for (int i = 0; i < 4; i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];
				
				// 다음 행선지가 범위 안이면
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]) {
					if (map[nr][nc] == 0) { // 안익은 토마토라면
						queue.add(new int[] {nr, nc}); // 큐에 넣고
						visited[nr][nc] = true; // 해당 좌표를 방문
						map[nr][nc] = map[x][y] + 1;
						// 방문한 경우에 값을 1씩 증가시킴
						result = map[nr][nc];
//						result += 1; // 이렇게 하면 총 방문 횟수 나옴
					}
				}
			}
		}
	}
}