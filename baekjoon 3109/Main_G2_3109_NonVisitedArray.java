package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_3109_NonVisitedArray {
	static int r;
	static int c;
	static char[][] map;
	static int[] dr = new int[] {-1, 0, 1}; // 오른쪽 , 오른쪽 위 대각선, 오른쪽 아래 대각선
	static int count; // 파이프 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		// 맵 입력
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 0~r까지 행의 0번째 열부터 시작
		for (int i = 0; i < r; i++) {
			map[i][0] = 'x'; // 시작 위치를 방문했음으로 변경
			dfs(i, 0);
		}
		System.out.println(count);
	}
	
	public static boolean dfs(int x, int y) {
		if (y == c - 1) { // y가 c-1이란 소리는 도착이란 뜻
			count++;
			return true; // 참을 리턴
		}
		
		for (int i = 0; i < 3; i++) { // 3가지 방향 이동가능
			int nr = x + dr[i]; // 이건 위 중간 아래
			int nc = y + 1; // 이건 무조건 1
			// 범위를 벗어나는지, x로 표시된 곳인지
			if (nr < 0 || nr >= r || map[nr][nc] == 'x') {
					continue;
			}
			// 방문을 했음으로 표시
			map[nr][nc] = 'x';
			if (dfs(nr, nc)) // 재귀를 돌려서 true값이 들어온다면
				return true; // 이것은 트루로 return
			
			// x, y에서 시작한 것이 도착을 하게 되면 해당 위치로 가는 가장 먼저 탐색되는 방법이고
			// 이 방법으로 빵집에 도달하게 되면 그 경우 다른 루트들은 false인 상태가 된다.
		}
		return false; // 불가능함을 리턴
	}
}
