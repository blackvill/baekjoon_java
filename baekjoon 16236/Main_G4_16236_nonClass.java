package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16236_nonClass {
	static int[][] map;
	static int[][] distance;
	static int n;
	static int result;
	static int min_x, min_y;
	static int min_dist;
	static int size;
	static int eat;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		
		map = new int[n][n];

		size = 2; // 상어의 시작 사이즈는 2
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 해당 좌표의 값이 9이면 아기상어의 좌표
				if (map[i][j] == 9) {
					x = i; // 아기 상어의 x위치
					y = j; // 아기 상어의 y위치
					map[i][j] = 0; 
				}
			}
		}
		
		while(true){
			// 초기화
			min_dist = Integer.MAX_VALUE;
	        min_x = Integer.MAX_VALUE;
	        min_y = Integer.MAX_VALUE;

			distance = new int[n][n]; // 아기 상어와의 거리를 나타낼 배열

	        // bfs 탐색
            bfs(x, y);
            
            // 최소 x와 최소 y가 변경이 되었다면 먹으러 갈 수 있는 것
            if(min_x != Integer.MAX_VALUE && min_y != Integer.MAX_VALUE){
                result += distance[min_x][min_y];
                // distance배열에 해당 좌표에 상어가 해당 위치로 가는데의 거리가 들어있기때문에
                // 그냥 더해주면 된다.
                eat++;
                // eat를 증가
                
                // 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
                // eat가 크기와 같다면 크기를 증가
                // eat을 0으로 초기화
                if(eat == size){
                    size++;
                    eat = 0;
                }
                // 물고기를 먹으면, 그 칸은 빈 칸이 된다.
                // 그래서 해당 위치를 0으로 바꿔준다
                map[min_x][min_y] = 0;

                x = min_x;
                y = min_y;
            }
            else{ // 변경되지 않았다면
                break; // 갈수 있는곳이 없는것이니까 탈출
            }
        }
		
        System.out.println(result);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>(); // 탐색할 노드를 담을 queue
		distance[x][y] = 0; // 해당 좌표에 상어가 있으므로 0으로 변경
		q.offer(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] cur = q.poll(); // 현재 방문할 노드를 queue에서 꺼내 온다.
			x = cur[0];
			y = cur[1];

			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				// 범위 안에 들어가고
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					// 해당 위치의 거리가 0이 아니거나(이미 거리 계산을 했거나)
					// 해당 위치의 값이 size보다 크다면(못먹으니까)
					if (distance[nr][nc] != 0 || map[nr][nc] > size)
						continue;
					// 거리 +1
					distance[nr][nc] = distance[x][y] + 1;
					
					// 해당 위치의 값이 0이 아니고(물고기가 있고)
					// 해당 위치가 size보다 작으면
					if (map[nr][nc] != 0 && map[nr][nc] < size) {
						// 최소 거리보다 해당 위치의 거리가 짧다면
						if (min_dist > distance[nr][nc]) { // 갱신
							min_x = nr;
							min_y = nc;
							min_dist = distance[nr][nc];
						}
						else if (min_dist == distance[nr][nc]) { // 같다면
							// 가장 위쪽을 우선적으로 먹고
							// 가장 위쪽에 수가 여러마리라면 가장 왼쪽
							// 같은 행인데 왼쪽이라면
							if (min_x > nr) {
									min_x = nr;
									min_y = nc;
							} else if (min_x == nr && min_y > nc) {
								min_x = nr;
								min_y = nc;
							}
						}
					}
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}