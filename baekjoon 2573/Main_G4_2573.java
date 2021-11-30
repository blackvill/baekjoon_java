package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2573_김재욱 {
	static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
 
    static int n, m;
    static int[][] map;
    
    public static class Ice {
    	int x;
    	int y;
    	
    	Ice (int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int ans = 0;
        int cnt = 0;
 
        while ((cnt = spread()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }
 
            melt();
            ans++;
        }
 
        System.out.println(ans);
    }
 
    public static int spread() {
        boolean[][] visited = new boolean[n][m];
 
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited); // DFS 방식을 통해 총 몇개의 빙하로 나누어졌는지 구할 수 있음.
                    cnt++;
                }
            }
        }
        return cnt;
    }
 
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
 
        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + dr[i];
            dy = y + dc[i];
 
            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                continue;
            }
 
            if (map[dx][dy] != 0 && !visited[dx][dy]) {
                dfs(dx, dy, visited);
            }
        }
    }
 
    // 빙하를 녹이는 함수.
    public static void melt() {
        Queue<Ice> q = new LinkedList<>();
 
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    q.offer(new Ice(i, j));
                    visited[i][j] = true;
                }
            }
        }
 
        int dx;
        int dy;
        
        while (!q.isEmpty()) {
            Ice ice = q.poll();
 
            int num = 0;
 
            for (int i = 0; i < 4; i++) {
                dx = ice.x + dr[i];
                dy = ice.y + dc[i];
 
                if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }
 
                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    num++;
                }
            }
 
            if (map[ice.x][ice.y] - num < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= num;
            }
        }
    }
}