package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2583 {
    static int m;
    static int n;
    static int k;
    static boolean[][] visited;
    static int[][] map;
	
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        visited = new boolean[m][n];
 
        for(int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine());
        	
            int lx = Integer.parseInt(st.nextToken()); // 왼쪽 위 x
            int ly = Integer.parseInt(st.nextToken()); // 왼쪽 위 y
            int rx = Integer.parseInt(st.nextToken()); // 오른쪽 아래 x
            int ry = Integer.parseInt(st.nextToken()); // 오른쪽 아래 y
            
            for(int y = ly; y < ry; y++) {
                for(int x = lx; x < rx; x++) {
                    map[y][x] = 1;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    int data = bfs(i, j);
                    list.add(data);
                    count++; // 분리되는 영역의 개수
                }
            }
        }
 
        System.out.println(count);
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
	}
 
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1; // 공간의 크기
 
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
 
            for(int i=0; i<4; i++) {
                int nr = curX + dx[i];
                int nc = curY + dy[i];
 
                if(nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    if(!visited[nr][nc] && map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
