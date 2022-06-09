package BOJ_gold;

import java.util.*;
import java.io.*;

public class Main_G5_13549 {
	static int min = Integer.MAX_VALUE;
    static int n, k;
    static int max = 100000; // 최대 이동 가능 위치
    static boolean[] visited = new boolean[max + 1];
    
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
    	// 입력받기
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        // bfs 탐색
        bfs();
        
        System.out.println(min);
    }
    
    public static void bfs() {
        Queue<Subin> q = new LinkedList<>();
        
        q.offer(new Subin(n, 0));
        
        while(!q.isEmpty()) {
            Subin subin = q.poll();
            visited[subin.loc] = true;
            
            // 목표지점에 도착했을 경우
            if (subin.loc == k)
            	// 가장 적은 시간을 찾기 위해 Math.min을 사용해서 최단시간을 탐색
            	min = Math.min(min, subin.time);
            
            // 순간이동을 하였을 때 최대 거리를 넘어가지 않고, 해당 위치를 방문한적이 없다면
            if (subin.loc * 2 <= max && visited[subin.loc * 2] == false)
            	// 순간이동은 시간의 증가가 없음
            	q.offer(new Subin(subin.loc * 2, subin.time));
            
            // X+1로 이동하였을 때 최대 거리를 넘어가지 않고, 해당 위치를 방문한적이 없다면
            if (subin.loc + 1 <= max && visited[subin.loc + 1] == false)
            	// 1초 증가
            	q.offer(new Subin(subin.loc + 1, subin.time + 1));
            
            // X-1로 이동하였을 때 최대 거리를 넘어가지 않고, 해당 위치를 방문한적이 없다면
            if (subin.loc - 1 >= 0 && visited[subin.loc - 1] == false)
            	// 1초 증가
            	q.offer(new Subin(subin.loc - 1, subin.time + 1));
        }
    }
    
    public static class Subin {
        int loc; // 위치
        int time; // 시간
        
        public Subin(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }

}
