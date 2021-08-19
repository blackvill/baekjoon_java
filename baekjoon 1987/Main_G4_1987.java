package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1987 {
	static int r; // 행
	static int c; // 열
	static int[][] map;
	static boolean[] visited = new boolean[26]; // 사용한 알파벳
	static int[] dr = new int[]{-1, 1, 0, 0}; // 상하좌우 
	static int[] dc = new int[]{0, 0, -1, 1}; // 상하좌우 
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		// 값 입력 받기
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0, 0);
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int count) {
		if (visited[map[x][y] - 'A']) { // 방문한곳이면
			result = Math.max(result, count); // count값을 결과값과 비교해서 더 큰것을 고른다
			return;
		}
		else {
			visited[map[x][y] - 'A'] = true; // 방문한 곳으로 바꿔준다.
			for (int i = 0; i < 4; i++) { // 4방향이니까 
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if (0 > nr || 0 > nc || nr >= r || nc >= c) { // 범위 벗어나는 지 체크
					continue;
				}
				else // 안벗어나면
					dfs(nr, nc, count + 1); // 재귀
			}
			visited[map[x][y] - 'A'] = false; // 방문했다고 표시했던것을 방문하지 않음으로 변경한다
		}
	}
}
