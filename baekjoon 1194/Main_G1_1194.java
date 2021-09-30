package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194 {
	static int n;
	static int m;
	static char map[][];
	static boolean visited[][][];
	static User user;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	static class User {
		int x; // 유저의 x좌표값
		int y; // 유저의 y좌표값
		int key; // 유저가 가지고 있는 키값
		int move; // 유저의 이동 횟수
		
		public User(int x, int y, int key, int move) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m][64];
		
		for (int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = c[j];
				if (map[i][j] == '0')
					user = new User(i, j, 0, 0);
			}
		}
		
//		bfs(user.x, user.y); // 유저의 위치값을 가지고 bfs를 실행
		
		bfs2(user.x, user.y); // 유저의 위치값을 가지고 bfs를 실행
	}

//	public static void bfs(int x, int y) {
//		Queue<User> q = new LinkedList<User>();
//		q.add(new User(x, y, 0, 0)); // 시작은 이동횟수가 0회이니까
//		visited[x][y][0] = true;
//		
//		while (!q.isEmpty()) {
//			User cur = q.poll();
//			
//			int key = cur.key;
//			int move = cur.move;
//			
//			System.out.println(move + "움직임");
//			System.out.println("map[x][y] 의 값 : " + cur.x + ", " + cur.y + " : " + map[cur.x][cur.y]);
//			
//			if (map[cur.x][cur.y] == '1') {
//				// 전부 탐색하지 않아도 1(탈출구)를 만나면 거기서 종료
//				System.out.println(move);
//				return;
//			}
//			
//			for (int i = 0; i < 4; i++) {
//				int nx = cur.x + dr[i];
//				int ny = cur.y + dc[i];
//				
//				System.out.println(key);
//				
//				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//					if (map[nx][ny] == '#' || visited[nx][ny][key]) {
//						// 해당 좌표가 벽이거나 키를 가지고 이미 이동 한 적이 있다면
//						continue;
//					}
//					if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
//						// 해당 좌표가 키 일때
//
//						int shift = map[nx][ny] - 'a';
//						key |= 1 << shift; // 열쇠 값을 변경
//						
//						visited[nx][ny][key] = true; // 해당 열쇠를 가지고 있을때의 방문처리
//						q.offer(new User(nx, ny, key, move + 1)); // 큐에 넣기
//					}
//					else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
//						// 해당 좌표가 문일 때
//						int shift = map[nx][ny] - 'A';
//						if ((key & 1 << shift) != 0) {
//							// 만약 열쇠가 있는 경우라면
//							visited[nx][ny][key] = true;
//							q.offer(new User(nx, ny, key, move + 1));
//						}
//					}
//					else {
//						visited[nx][ny][key] = true;
//						q.offer(new User(nx, ny, key, move + 1));
//					}
//				}
//			}
//		}
//		System.out.println("-1");
//	}
	
	public static void bfs2(int x, int y) {
		Queue<User> q = new LinkedList<User>();
		q.add(new User(x, y, 0, 0)); // 시작은 이동횟수가 0회이니까
		visited[x][y][0] = true;
		
		while (!q.isEmpty()) {
			User cur = q.poll();
			
			int key = cur.key;
			int move = cur.move;
			
			if (map[cur.x][cur.y] == '1') {
				// 전부 탐색하지 않아도 1(탈출구)를 만나면 거기서 종료
				System.out.println(move);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dr[i];
				int ny = cur.y + dc[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == '#' || visited[nx][ny][key]) {
						// 해당 좌표가 벽이거나 키를 가지고 이미 이동 한 적이 있다면
						continue;
					}
					if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
						// 해당 좌표가 키 일때
						int shift = map[nx][ny] - 'a';
						int curkey = key | 1 << shift;
						
						if (!visited[nx][ny][curkey]) { // 지금 열쇠의 상태로 방문하지 않은 경우에만
							visited[nx][ny][curkey] = true; // 지금의 상태로 방문처리
							visited[nx][ny][key] = true; // 이전의 상태로 방문처리
							q.offer(new User(nx, ny, curkey, move + 1));
						}
					}
					else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
						// 해당 좌표가 문일 때
						int shift = map[nx][ny] - 'A';
						if ((key & 1 << shift) != 0) {
							// 만약 열쇠가 있는 경우라면
							visited[nx][ny][key] = true;
							q.offer(new User(nx, ny, key, move + 1));
						}
					}
					else {
						visited[nx][ny][key] = true;
						q.offer(new User(nx, ny, key, move + 1));
					}
				}
			}
		}
		System.out.println("-1");
	}
}
