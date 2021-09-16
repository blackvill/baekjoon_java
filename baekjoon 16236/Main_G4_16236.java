package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16236 {
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
	
	public static class Baby {
		int x;
        int y;
        
        public Baby(int x, int y) {
            this.x = x;
            this.y = y;
        }
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		
		map = new int[n][n];
		distance = new int[n][n];
		
		size = 2;

		int x = 0;
		int y = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		
		while(true){
			min_dist = Integer.MAX_VALUE;
	        min_x = Integer.MAX_VALUE;
	        min_y = Integer.MAX_VALUE;

	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                distance[i][j] = 0;
	            }
	        }

            bfs(x, y);
            
            if(min_x != Integer.MAX_VALUE && min_y != Integer.MAX_VALUE){
                result += distance[min_x][min_y];
                eat++;
                
                if(eat == size){
                    size++;
                    eat = 0;
                }
                map[min_x][min_y] = 0;

                x = min_x;
                y = min_y;
            }
            else{
                break;
            }
        }
        System.out.println(result);
	}

	public static void bfs(int x, int y) {
		Queue<Baby> q = new LinkedList<Baby>(); // 탐색할 노드를 담을 queue
		distance[x][y] = 0; // 해당 좌표를 상어가 지나가므로 0으로 변경
		q.offer(new Baby(x, y));

		while (!q.isEmpty()) {
			Baby cur = q.poll(); // 현재 방문할 노드를 queue에서 꺼내 온다.
			x = cur.x;
			y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (distance[nr][nc] != 0 || map[nr][nc] > size)
						continue;
					distance[nr][nc] = distance[x][y] + 1;
					
					if (map[nr][nc] != 0 && map[nr][nc] < size) {
						if (min_dist > distance[nr][nc]) {
							min_x = nr;
							min_y = nc;
							min_dist = distance[nr][nc];
						}
						else if (min_dist == distance[nr][nc]) {
							if (min_x == nr && min_y > nc) {
									min_x = nr;
									min_y = nc;
							} else if (min_x > nr) {
								min_x = nr;
								min_y = nc;
							}
						}
					}
					q.offer(new Baby(nr, nc));
				}
			}
		}
	}
}
