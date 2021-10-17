package BOJ_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3055 {
	static int R;
	static int C;
	static int result;
	static int eX = 0, eY = 0;
	static int X = 0, Y = 0;
	
	static char map[][];
	static boolean visit[][];
	
	static Queue<Location> q;
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static class Location{
		int x, y;
		
		Location(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		result = 0;
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		q = new LinkedList<Location>();

		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'D') { // 도착지
					eX = i;
					eY = j;
				}
				else if(map[i][j] == 'S') { // 고슴도치
					X = i;
					Y = j;
				}
			}
		}

		bfs();
	}

	public static void bfs() {
		q.add(new Location(-1, -1));
		q.add(new Location(X, Y));

		while(!q.isEmpty()) {
			Location point = q.poll();
			
			if(point.x == -1) {
				water();
				result++;
				
				if(!q.isEmpty())
					q.add(point);
				
				continue;
			}

			if(point.x == eX && point.y == eY) {
				System.out.println(result - 1);
				
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
					
				if(nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
					visit[nx][ny] = true;
					
					q.add(new Location(nx, ny));
				}
			}
		}

		System.out.println("KAKTUS");
	}

	public static void water() {
		char temp[][] = new char[R][C];

		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				temp[i][j] = map[i][j];
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '*') {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if(nx >= 0 && ny >= 0 && nx < R && ny < C && (map[nx][ny] == '.' || map[nx][ny] == 'S'))
							temp[nx][ny] = '*';
					}
				}
			}
		}

		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}