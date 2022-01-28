package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2615 {
	static int[][] map = new int[21][21];
	static int[][][] visited = new int[21][21][4]; // 4방탐색에 대한 값들을 3차원으로 저장
	
	static int[] dx = { 1, 1, 0, -1};
	static int[] dy = { 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(check());
	}

	private static String check() {
		for (int j = 1; j <= 19; j++) {
			for (int i = 1; i <= 19; i++) {
				// 돌이 놓여있는 곳이라면
				if (map[i][j] != 0) {
					// 4방 탐색
					for (int d = 0; d < 4; d++) {
						// 현재 방문상태가 0이고, 오목이 완성되면
						if (visited[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
							return map[i][j] + "\n" + i + " " + j + "\n";
						}
					}
				}
			}
		}
		return "0"; // 승부가 안난 경우
	}

	private static int calc(int x, int y, int dir, int color) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		// 총 개수 세기
		if (map[nx][ny] == color) {
			return visited[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
		}
		return 1;
	}
}