package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_10158_김재욱_memory_leak {
	static int w, h; // 처음 배열 크기
	static int x, y; // 시작 x, y
	static int n; // 이동시간
	static int[][] map;
	static int[] dr = new int[] {1, -1}; // 위 아래
	static int[] dc = new int[] {1, -1}; // 오른쪽 왼쪽
	static int r_cnt, c_cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[w][h];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int nr = x + dr[r_cnt];
			int nc = y + dc[c_cnt];
			
			if (0 >= nr || nr >= w) {
				if (r_cnt == 1)
					r_cnt = 0;
				else
					r_cnt++;
			}
			if (0 >= nc || nc >= h) {
				if (c_cnt == 1)
					c_cnt = 0;
				else
					c_cnt++;
			}
			x = nr;
			y = nc;
		}
		System.out.println(x + " " + y);
	}
}
