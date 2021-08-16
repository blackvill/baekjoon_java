package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_1952 {
	static boolean visit[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         int M = Integer.parseInt(st.nextToken());
         int N = Integer.parseInt(st.nextToken());
         
         visit = new boolean[M][N];
         
         int x = 0;
         int y = 0;
         int dir = 1;
         int cnt = 0;
         
         while(true) {
             if(visit[y][x])
                 break;
             visit[y][x] = true;
             
             int nx = x + dx[dir];
             int ny = y + dy[dir];
             
             if(0 > nx || nx >= N || 0 > ny || ny >= M || visit[ny][nx]) {
                 if(dir == 3)
                     dir = 0;
                 else
                     dir++;
                 cnt++;
             }
             x = x + dx[dir];
             y = y + dy[dir];
        }
        System.out.println(cnt-1);
    }
}
