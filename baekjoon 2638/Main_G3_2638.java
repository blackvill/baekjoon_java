package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G3_2638 {
	static int n, m;
	static int count, time;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    
        count = 0; // 치즈 개수
        time = 0; // 걸린 시간
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 치즈라면 총 치즈 개수 증가
                if (map[i][j] == 1)
                	count++;
            }
        }

        while (count != 0) {
        	dfs1(0, 0); // 외부의 공기인지 체크
            visited = new boolean[n][m]; // 방문처리 배열
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                	// 치즈이고 방문 안했다면
                    if (map[i][j] == 1 && !visited[i][j])
                    	dfs2(i, j);
                }
            }

            // 위에서 방문처리를 하였으니 다시 초기화
            visited = new boolean[n][m];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                	// 녹을 치즈라면 공기로 변경
                	if (map[i][j] == -1)
                		map[i][j] = 2;
                }
            }

            time++; // 시간 증가
        }

        System.out.println(time);
    }

    // 외부 공기인지 체크
    static void dfs1(int x, int y) {
        visited[x][y] = true;
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위, 방문, 치즈의 경우
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 1)
            	continue;

            map[nx][ny] = 2;
            dfs1(nx, ny);
        }
    }

    static void dfs2(int x, int y) {
        visited[x][y] = true; // 방문 처리

        // 치즈이고 녹는다면
        if (map[x][y] == 1 && check(x, y)) {
            count--; // 총 개수 감소
            map[x][y] = -1; // 녹은 치즈는 -1으로 바꿔준다
        }

        // 4방탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위, 방문, 공기의 경우
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0)
            	continue;

            // 추가 탐색
            dfs2(nx, ny);
        }
    }

    // 치즈가 녹는 지 체크
    static boolean check(int x, int y) {
        int air = 0; // 공기 갯수
        
        // 4방탐색하면서
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나면
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
            	continue;
            
            // 주변에 공기라면
            if (map[nx][ny] == 2)
            	air++;
        }

        return air >= 2;
    }
}
