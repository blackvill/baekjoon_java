package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178 {
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visited; // 방문배열
	static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
	static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(map[n - 1][m - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});

		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curR = cur[0];
			int curC = cur[1];

			for(int i=0; i<4; i++) {
				int newR = curR + dx[i];
				int newC = curC + dy[i];
				if (newR < 0 || newC < 0 || newR >= n || newC >= m)
					continue;
				if (visited[newR][newC] || map[newR][newC] == 0)
					continue;
				q.add(new int[] {newR, newC});
				map[newR][newC] = map[curR][curC] + 1;
				visited[newR][newC] = true;
			}
		}
	}
}