package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070_dfs {
	static int n;
    static int[][] map;
    static int count;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        dfs(1, 2, 0);
        System.out.println(count);
    }
    
    // 방향이 0일 때는 파이프가 가로 방향, 1일 때는 세로 방향, 2일 때는 대각선 방향
    public static void dfs(int x, int y, int dir) {
        if (x == n && y == n) { // 종료 조건
            count++;
            return;
        }
        // 무조건 증가하는 경우만 발생한다.
        int nx = x + 1;
        int ny = y + 1;
        
        // 파이프가 가로 방향일 경우
        if(dir == 0) {
            if (ny <= n && map[x][ny] == 0) { // 오른쪽
                dfs(x, ny, 0);
            }
            // 대각선으로 이동
            if (ny <= n && nx <= n && !is_wall(nx, ny)) {
                dfs(nx, ny, 2);
            }
        }
        // 파이프가 세로 방향일 경우
        if(dir == 1) {
            if (nx <= n && map[nx][y] == 0) { // 아래쪽
                dfs(nx, y, 1);
            }
            // 대각선으로 이동
            if (ny <= n && nx <= n && !is_wall(nx, ny)) {
                dfs(nx, ny, 2);
            }
        }
        // 파이프가 대각선일 경우
        if(dir == 2) {
            if (ny <= n && map[x][ny] == 0) { // 오른쪽
                dfs(x, ny, 0);
            }
            if (nx <= n && map[nx][y] == 0) { // 아래쪽
                dfs(nx, y, 1);
            }
            // 대각선으로 이동
            if (ny <= n && nx <= n && !is_wall(nx, ny)) {
                dfs(nx, ny, 2);
            }
        }
    }
    
    public static boolean is_wall(int x, int y) {
    	if (map[x - 1][y] == 1 || map[x][y - 1] == 1 || map[x][y] == 1)
    		return true;
    	return false;
    }
}