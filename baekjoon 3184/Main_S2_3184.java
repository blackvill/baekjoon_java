package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_3184 {
	static int r, c;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int o = 0; // 각 영역을 탐색할때 쓸 양의 수
	static int v = 0; // 각 영역을 탐색할때 쓸 늑대의 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sheep = 0; // 정답으로 출력할 남아있는 양의 수
		int wolf = 0; // 정답으로 출력할 남아있는 늑대의 수

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c];

		// char로 쪼개서 map에 넣기
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && (map[i][j] == 'o' || map[i][j] == 'v')) {
					// 매 탐색마다 새로 하므로 초기화
					o = v = 0;
					// dfs 탐색
					dfs(i, j);
					
					// 양이 늑대보다 많으면
					if(o > v)
						sheep += o; // 양을 증가
					else // 아니면
						wolf += v; // 늑대 증가
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true; // 방문체크
		
		// 양이나 늑대일 경우 횟수 증가
		if (map[x][y] == 'v')
			v++;
		if (map[x][y] == 'o')
			o++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			// 범위 벗어나거나 방문했거나 울타리라면
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || map[nx][ny] == '#')
				continue;
			visited[nx][ny] = true; // 방문체크
			dfs(nx, ny);
		}
	}
}