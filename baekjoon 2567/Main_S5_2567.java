package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2567 {
	
	static int[][] map;
	static int n;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, -1, 0, 1};
	static int row;
	static int col;
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[100][100];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			for (int r = row; r < row + 10; r++) {
				for (int c = col; c < col + 10; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j  = 0; j < 100; j++) {
				for (int k = 0; k < 4; k++) {
					// 배열에 닿아있다면 이 부분의 길이를 더한다.
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (map[i][j] == 1 && (0 > nr || nr >= 100 || 0 > nc || nc >= 100))
						count++;
					else { // 배열의 안에 있다면
						if (map[i][j] == 1 && map[nr][nc] == 0)
							count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
