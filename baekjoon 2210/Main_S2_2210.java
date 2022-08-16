package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_2210 {
	static HashSet<String> set = new HashSet<>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열을 구해야하므로 문자열로 배열로 처리
		String[][] map = new String[5][5];

		// 배열 채우기
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 숫자가 아니라 문자열로 채움
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		// 배열 시작점을 옮겨가면 dfs 탐색
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(map, i, j, 0, map[i][j]);
			}
		}
		
		System.out.println(set.size());
	}

	public static void dfs(String[][] map, int x, int y, int depth, String var) {
		// 5번 탐색이면
		if (depth == 5) {
			// set은 자동 중복 처리
			set.add(var);
			return;
		}
		
		// 4방탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 벗어나면
			if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
				continue;
			
			dfs(map, nx, ny, depth + 1, var + map[nx][ny]);
		}
	}
}