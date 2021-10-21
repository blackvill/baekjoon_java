package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G5_2174 {
	static int A, B, N, M;
    static int map[][];
    
    static int[] dest = { 0, 1, 2, 3 }; // 북, 동, 남, 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static Robot[] robots;
    
    static class Robot {
        int x, y, dest;
 
        public Robot(int x, int y, int dest) {
            super();
            this.x = x;
            this.y = y;
            this.dest = dest;
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        A = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 세로
        
        map = new int[B][A];
 
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 로봇 개수
        M = Integer.parseInt(st.nextToken()); // 명령 개수
        
        robots = new Robot[N + 1];
 
        // 로봇의 초기 위치 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int b = Integer.parseInt(st.nextToken()) - 1; // X
            int a = Integer.parseInt(st.nextToken()) - 1; // Y
            
            char tmp = st.nextToken().charAt(0); // 방향
            // 방향 설정 북->남, 남->북
            int d = 0;
            
            if (tmp == 'N')
            	d = 2;
            else if (tmp == 'E')
            	d = 1;
            else if (tmp == 'S')
            	d = 0;
            else
            	d = 3;
 
            map[a][b] = i;
            robots[i] = new Robot(a, b, d);
        }
 
        // 명령
        String res = "";
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            
            char m = st.nextToken().charAt(0); // 동작
            
            int g = Integer.parseInt(st.nextToken()); // 반복
            
            res = go(a, m, g);
            // 잘못된 명령일 경우
            if(!res.equals("OK")) {
                System.out.println(res);
                break;
            }
        }
        
        if(res.equals("OK"))
        	System.out.println(res);
        
    }
 
    private static String go(int n, char command, int move) {
        Robot now = robots[n];
        
        // L : 오른쪽으로 90도 회전
        if (command == 'L') 
        	for (int i = 0; i < move; i++) {
        		if (robots[n].dest == 3)
        			robots[n].dest = 0;
        		else
        			robots[n].dest += 1;
        	}
        // R : 왼쪽으로 90도 회전
        else if (command == 'R') 
        	for (int i = 0; i < move; i++) {
        		if (robots[n].dest == 0)
        			robots[n].dest = 3;
        		else
        			robots[n].dest -= 1;
        	}
        // F : 전진
        else if (command == 'F') {
            int nx = now.x;
            int ny = now.y;
            
            for (int i = 0; i < move; i++) {
                nx += dr[now.dest];
                ny += dc[now.dest];
                // n번 로봇이 벽에 충돌
                if(nx < 0 || nx >= B || ny < 0 || ny >= A)
                    return "Robot " + n + " crashes into the wall";
                // n번 로봇이 로봇에 충돌
                if(map[nx][ny] != 0) 
                    return "Robot "+ n + " crashes into robot " + map[nx][ny];
            }
            
            // 로봇 정보 갱신
            robots[n] = new Robot(nx, ny, now.dest);
            // 로봇 이동
            map[now.x][now.y] = 0;
            map[nx][ny] = n;
        }
        
        return "OK";
    }
}