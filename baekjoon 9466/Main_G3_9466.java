package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G3_9466 {
	static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
 
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 배열에 값을 넣기
            for(int i = 1; i < n + 1; i++) 
                arr[i] = Integer.parseInt(st.nextToken());
 
            // dfs 탐색
            for(int i = 1; i < n + 1; i++)
                dfs(i);
 
            System.out.println(n - count);
        }
    }
 
    static void dfs(int now) { 
    	// 이미 방문한 것이라면 리턴
        if (visited[now])
            return;
 
        // 현재 위치를 방문 처리
        visited[now] = true;
        // 다음 방문은 배열의 현재 값
        int next = arr[now];
 
        // 다음 방문이 방문하지 않은 것이라면
        if (!visited[next])
            dfs(next); // 추가 탐색
        else {
        	// 싸이클이 형성 되었는가 판단
            if (!finished[next]) {
                count++; // 횟수 증가
                // 다음부터 지금이 아닐때까지 배열의 값으로 이동하면서
                for (int i = next; i != now; i = arr[i])
                    count++; // 카운트 증가
            }
        }
        
        finished[now] = true;
    }
}
