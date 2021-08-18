package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_16926 {

	static int n;
	static int m;
	static int r;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}; // 0,0 기준으로 하 우 상 좌 
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    r = Integer.parseInt(st.nextToken());
	    
	    map = new int[n][m];
	    for (int i = 0; i < n; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for (int j = 0; j < m; j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    // 몇개의 블럭을 회전시켜야 하는지
	    int block = Math.min(n, m) / 2;
	    
	    for (int i = 0; i < r; i++) { // 회전수만큼 반복
	    	for (int j = 0; j < block; j++) { // 블럭만큼 반복
		   		int count = 0; // 방향
		   		int x = j;
		   		int y = j;
		   		int temp = map[x][y]; // 현재 좌표의 값을 저장
		   		while(count < 4) { // 4방향이 나왔다면 안으로 들어가야함 그러니까 그때까지만 반복
		   			int nx = x + dx[count];
		   			int ny = y + dy[count];
		   			// 조건 확인
	    			if(nx < j || ny < j || nx >= n - j || ny >= m - j) {
	    				count++;
	    			} else {
		                int temp2 = map[nx][ny];
		                map[nx][ny] = temp;
		                temp = temp2;
		                x = nx;
		                y = ny;
	    			}
	            }
	        }
	    }
	    // 출력문
	    for (int i = 0; i < n; i++) {
	    	for (int j = 0; j < m; j++) {
	    		System.out.print(map[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	}
}