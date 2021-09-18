package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2636 {
	static int r; // 행 
	static int c; // 열
	static int[][] map; // 판의 정보를 담을 2차원 배열
	static boolean[][] visited; // 방문처리를 위한 2차원 배열
	static int cheeze; // 치즈의 개수
	static int cnt;
	static int time; // 다 녹는데 까지 걸리는 시간
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
//		visited = new boolean[r][c];
		// 여기서 visited 생성을 해주면 에러 발생 (무한 반복돈다.)
		// 초기화 처리를 해줘서 해결 가능할듯
		
		// map 값 입력 및 cheeze 수 count
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) 
					cheeze++;
			}
		}
		
//		System.out.println("값 입력은 완료");
		
		while (cheeze != 0) { 
			cnt = cheeze; // cnt는 이전 bfs를 돌았을 때의 치즈 수
			// 즉, 이번 bfs를 돌았을때 치즈의 수가 0이되면 이 while문을 돌지 않기 때문에
			// 이전 치즈수를 출력하기 위한 값
			
			visited = new boolean[r][c];
			// 여기서  생성을 하거나 bfs에서 생성을 하지 않으면
			// bfs를 한번 돌고나면 이미 다 탐색을 했기때문에 따로 초기화를 해주어야함
			
//			System.out.println("bfs 시작");
			bfs(0, 0); // 항상 0,0부터
//			System.out.println("bfs 종료");
			time++; // 시간 증가
		}
		
		// 만약 처음부터 cheeze가 0이라도 time은 0이기 때문에 괜찮다.
		System.out.println(time);
		System.out.println(cnt);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) { // 4방탐색
				int nx = cur[0] + dr[i];
				int ny = cur[1] + dc[i];
				
				if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] == true)
					// 범위를 벗어나거나 이미 방문한 곳이면 넘어간다
					continue;
				else {
					if (map[nx][ny] == 1) { // 치즈가 있는곳이라면
						cheeze--; // 치즈의 수 감소
						map[nx][ny] = 0; // 해당 자리를 0으로 변경
					} else if (map[nx][ny] == 0) { // 치즈가 없는 곳이라면
						q.offer(new int[] {nx, ny}); // 해당 좌표를 큐에 넣어 탐색
					}
					visited[nx][ny] = true; // 방문처리
					// 치즈일 때는 q에 담지 않기 때문에 추가적인 탐색을 하지 않는다.
				}
			}
		}
	}
}