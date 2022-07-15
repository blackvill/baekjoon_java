package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G5_17836 {
	static int n, m, t;
	static int map[][];
	static boolean visited[][][];
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static class point {
		int x; // x좌표
		int y; // y좌표
		int time; // 걸린 시간
		boolean gram; // 그람 유무
		
		public point(int x, int y, int time, boolean gram) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.gram = gram;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m][2]; // 0은 그람 없을 때, 1은 그람 있을 때
		
		// 맵 채우기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = bfs(0, 0);
		
		// 조건 맞춰서 결과 출력
		if (ans == -1)
			System.out.println("Fail");
		else
			System.out.println(ans);
	}
	
	public static int bfs(int x, int y) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(x, y, 0, false));
		visited[x][y][0] = true;
		
		while (!q.isEmpty()) {
			point pos = q.poll();
			
			// 걸린 시간이 t보다 크면 탈출
			if (pos.time > t)
				break;
			
			// 도착지점에 도착하면 현재까지의 시간을 리턴
			if (pos.x == n - 1 && pos.y == m - 1)
				return pos.time;
			
			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dr[i];
				int ny = pos.y + dc[i];
				
				// 범위를 벗어나지 않는다면
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 그람을 소지하지 않았을 때
					if (!pos.gram) {
						// 그람이 아닌 곳은 그냥 탐색
						if (!visited[nx][ny][0] && map[nx][ny] == 0) {
							q.add(new point(nx, ny, pos.time + 1, pos.gram));
						}
						// 그람인 곳은 그람을 습득한 것으로 변경
						else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
							q.add(new point(nx, ny, pos.time + 1, true));
						}
						visited[nx][ny][0] = true;
					}
					// 그람을 소지했을 때
					else {
						// 방문하지 않은 곳이라면
						if (!visited[nx][ny][1]) {
							q.offer(new point(nx, ny, pos.time + 1, pos.gram));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		// 도착하지 못하면 -1
		return -1;
	}
}
