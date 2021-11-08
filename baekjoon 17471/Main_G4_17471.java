package BOJ_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17471 {
	static int n;
	static int min = Integer.MAX_VALUE;
    static int arr[]; // 각 구역의 인구
    static int map[][]; // 인접 배열
    static int area[]; 
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine()); // 구역의 개수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1번부터 기준이라 +1 하고 0번을 버림
        arr = new int[n + 1];
        area = new int[n + 1];
        map = new int[n + 1][n + 1];
        
        // 각 구역의 인구 (1부터 주어짐)
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 인접 구역 수 & 지역의 번호
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 인접한 구역의 수
            int count = Integer.parseInt(st.nextToken());
            
            for(int j = 1; j <= count; j++) {
                int loc = Integer.parseInt(st.nextToken());
                
                // 인접 배열에 입력
                map[i][loc] = 1;
                map[loc][i] = 1;
            }
        }
        dfs(1);
        
        // 최소값이 그대로라면 -1 아니면 최소값
        if(min != Integer.MAX_VALUE)
        	System.out.println(min);
        else
        	System.out.println(-1);
    }
    
    private static void dfs(int count) {
        if(count == n + 1) {
            int A = 0;
            int B = 0;
            
            for(int i = 1; i <= n; i++) {
                if(area[i] == 1)
                    A += arr[i];
                else
                    B += arr[i];
            }
            
            visited = new boolean[n + 1];
            
            // 인접한 구역 덩어리
            int cnt = 0;
            
            // 1번부터 연결되었는지를 확인한다.
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    check(i, area[i]);
                    cnt++;
                }
            }
            
            // 연결 정보를 다 확인 후에 구역 덩어리가 2개라면 최소값을 갱신
            if(cnt == 2) {
                if(min > Math.abs(A - B))
                    min =  Math.abs(A - B);
            }
            return;
        }
        
        area[count] = 1;
        dfs(count + 1);
        
        area[count] = 2;
        dfs(count + 1);
    }
    
    private static void check(int index, int num) {
    	// 방문처리
        visited[index] = true;
        
        for(int i = 1; i <= n; i++) {
            if(map[index][i] == 1 && !visited[i] && area[i] == num)
                check(i, num);
        }
    }
}