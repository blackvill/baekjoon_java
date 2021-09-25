package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_10709 {
	static int h;
	static int w;
	static int[][] map;
	static int[][] now;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		now = new int[h][w];
		
		for (int i = 0; i < h; i++) {
			char[] c = br.readLine().toCharArray();
			
			for (int j = 0; j < w; j++) {
				if (c[j] == 'c')
					now[i][j] = 0;
				else
					now[i][j] = -1;
			}
		}
		
		move();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(now[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void move() {
		for (int i = 0; i < h; i++) {
			int time = 0;
			boolean cloud = false;
			for (int j = 0; j < w; j++) {
				if (now[i][j] == 0) {
					time = 0;
					cloud = true;
				}
				if (now[i][j] == -1 && cloud) {
					time++;
					now[i][j] = time;
				}
				if (now[i][j] == -1 && !cloud) {
					continue;
				}
			}
		}
	}
}