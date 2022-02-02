package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_7562 {
	static int tt;
	static int n;
	static int x1, y1;
	static int x2, y2;

	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

	static int[][] visited = new int[301][301];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		tt = Integer.parseInt(st.nextToken());

		while(tt--!=0){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			cleanVisited();

			bfs(x1,y1,x2,y2);

			System.out.println(visited[x2][y2]);
		}

	}

	public static void bfs(int a, int b, int c, int d) {

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		visited[a][b] = 0;

		while(!q.isEmpty()) {
			Point p = q.poll();

			if(p.x == c && p.y == d)
				break;

			for(int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if(0 <= nx && nx < n && 0 <= ny & ny < n && (visited[nx][ny] == -1 || visited[p.x][p.y] + 1 < visited[nx][ny])){
					visited[nx][ny] = visited[p.x][p.y] + 1;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	public static void cleanVisited() {
		for(int i = 0; i <= 300; i++)
			for(int j = 0; j <= 300; j++)
				visited[i][j] = -1;
	}

	static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}