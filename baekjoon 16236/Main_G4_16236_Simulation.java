package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16236_Simulation {
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int result;
	static int size;
	static int eat;
	static Fish shark;
	static ArrayList<Fish> list;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 아기 상어의 정보를 담을 클래스
	public static class Fish {
		int x;
        int y;
        int dist;
        
        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		
		map = new int[n][n];
		list = new ArrayList<>();
		
		size = 2; // 상어의 시작 사이즈는 2
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 해당 좌표의 값이 9이면 아기상어의 좌표
				if (map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Fish(i, j, 0);
				}
			}
		}
		
		while (true) {
			visited = new boolean[n][n];
			find();
			if (!eat())
				break;
		}
		
		System.out.println(result);
	}
	
	public static void find() {
		Queue<Fish> q = new LinkedList<>();
		q.add(shark);
		visited[shark.x][shark.y] = true;
		
		while (!q.isEmpty()) {
			Fish baby = q.poll();
			int now = baby.dist;
			
			for (int i = 0; i < 4; i++) {
				int nx = baby.x + dr[i];
				int ny = baby.y + dc[i];
				
				// 범위를 벗어나거나 이미 방문한 곳이면 처리
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
					continue;
				
				// 0이 아니고 size보다 작으면
				if (map[nx][ny] != 0 && map[nx][ny] < size) {
					list.add(new Fish(nx, ny, now + 1));
					q.add(new Fish(nx, ny, now + 1));
					visited[nx][ny] = true;
				}
				
				// 지나가기만 하는 경우
				if (map[nx][ny] == 0 || map[nx][ny] == size) {
					q.add(new Fish(nx, ny, now + 1));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static boolean eat() {
		if (list.isEmpty()) {
			return false;
		}
		else {
			// 정렬
			Collections.sort(list, new Comparator<Fish>() {
				@Override
				public int compare(Fish o1, Fish o2) {
					// 1순위 가장 가까운거
					// 2순위 가장 위
					// 3순위 가장 왼쪽
					if (o1.dist > o2.dist) // 1이 거리가 먼 경우
						return 1;
					else if (o1.dist < o2.dist) // 2가 거리가 먼 경우
						return -1;
					else { // 같은경우
						// 가장 위를 먼저 찾고
						// 같다면 가장 왼쪽
						if (o1.x == o2.x) {
							if (o1.y > o2.y)
								return 1;
							else
								return -1;
						}
						else {
							if (o1.x > o2.x)
								return 1;
							else
								return -1;
						}
					}
				}
			});
			
			// 정렬이 된 상태에서 가장 앞에 있는것이 조건에 부합하는 거니까 먹으면 됨
			Fish eating = list.get(0);
			
			// 상어를 해당 위치로 이동 시키고 해당 칸의 물고기를 0으로 변경
			shark.x = eating.x;
			shark.y = eating.y;
			map[shark.x][shark.y] = 0;
			
			// 해당 고기를 먹기위해 이동한 거리를 더해줌
			result += eating.dist;
			
			// 먹었다는 count를 증가
			eat++;
			
			// 먹은 횟수가 size와 같다면 크기 증가
			if (size == eat) {
				size++;
				eat = 0;
			}

			list.clear();
			
			return true;
		}
	}
}