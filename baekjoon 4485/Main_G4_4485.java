package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_4485 {
	static int n;
	static int[][] map; // 기존에 값을 입력받기 위한 배열
	static int[][] rupee; // 이동하면서 최소값을 저장하기 위한 배열
	static int t; // 몇번 째 테케인지 출력하기 위한 변수
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = 1;
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			
			if (n == 0) // 0 입력 시 탈출
				break;
			
			map = new int[n][n];
			rupee = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // map값을 입력받는다.
					rupee[i][j] = Integer.MAX_VALUE; // 최소값을 구하는 배열이기 때문에 최대값으로 채워준다.
				}
			}
			rupee[0][0] = map[0][0];
			// 0,0에서 시작하기 때문에 rupee[0][0]에 map의 [0][0]값을 넣어준다.
			// 무조건 map[0][0]의 값을 가지고 간다는 뜻
			bfs();
			System.out.println("Problem " + t +": " + rupee[n - 1][n - 1]);
			t++;
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0}); // 0,0에서 시작을 하기때문에 큐에 넣어준다.
		
		while (!q.isEmpty()) {
			int[] cur = q.poll(); // 큐 값을 꺼내서 cur배열에 값을 넣어준다.
			
			for (int i = 0; i < 4; i++) { // 상하좌우로 이동할 수 있기 때문에 사방탐색을 해준다.
				int nx = cur[0] + dr[i]; 
				int ny = cur[1] + dc[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) { // 배열을 벗어나지 않고
					if (rupee[nx][ny] > rupee[cur[0]][cur[1]] + map[nx][ny]) {
						// 이동할려는 곳의 누적 비용이 (이전까지의 누적 비용 + 이동할려는 곳의 비용)보다 크다면
						// 이전까지의 누적비용 + 이동할려는 곳의 비용으로 바꿔준다.
						rupee[nx][ny] = rupee[cur[0]][cur[1]] + map[nx][ny];
						q.add(new int[] {nx, ny}); // 해당 좌표를 큐에 넣어준다.
					}
				}
			}
		}
		// 큐를 다 돌고나면 rupee[n - 1][n - 1]의 값은 이 위치까지의 최소비용이 된다.
	}
}
