package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_3187 {
	static boolean[][] isVisited;
    static char[][] map;
    
    static int r;
    static int c;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int sheep = 0;
    static int wolf = 0;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        isVisited = new boolean[r][c];
        
        // map 채우기
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '#')
                	isVisited[i][j] = true;
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
            	// 방문한 적이 없고 울타리가 아니라면            	
                if (!isVisited[i][j]) {
                    bfs(new Point(i, j));
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(point);
        
        isVisited[point.x][point.y] = true;
        
        int v = 0; // 늑대 수
        int k = 0; // 양 수
        
        while (!queue.isEmpty()) {
            Point point2 = queue.poll();
            
            int x = point2.x;
            int y = point2.y;
            
            // 양이면 양 카운트 증가
            if (map[x][y] == 'k') {
                k++;
            }
            // 늑대면 늑대 카운트 증가
            else if (map[x][y] == 'v') {
                v++;
            }
            
            // 사방탐색
            for (int i = 0; i < 4; i++) {
                int nr = point2.x + dx[i];
                int nc = point2.y + dy[i];
                
                // 범위 벗어나지 않고 방문한 적 없으면
                if (nr > 0 && nr < r && nc > 0 && nc < c && !isVisited[nr][nc]) {
                	// 방문 처리
                	isVisited[nr][nc] = true;
                	// 큐에 담아서 추가 탐색
                	queue.offer(new Point(nr, nc));
                }
            }
        }
        // 양이 많으면 늑대를 다 잡아먹으므로
        if (k > v) {
            sheep += k; // 양만 증가
        }
        // 아니라면
        else {
            wolf += v; // 늑대만 증가
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
