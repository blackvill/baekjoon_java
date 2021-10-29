package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_11725 {
	static int n ;
    static ArrayList<Integer>[] list; // 리스트의 배열
    static int[] parents; // 부모노드
    static boolean[] visited; // 방문처리


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 초기화
        list = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        // ArrayList의 배열을 만들어 주기 위해 초기화
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        // 값 입력받기
        for (int i = 1; i < n ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 각각에 추가를 해주는 이유 : 연결된 것이기 때문
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) { // dfs탐색을 하면서 탐색이 되지 않은 곳이라면
                dfs(i);
            }
        }
        
        // 2번 노드부터 출력을 하니까
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int x){
        if(visited[x]) { // 탐색했던 곳이면 탐색 필요가 없으니까 return
            return;
        }
        
        visited[x] = true; // 탐색을 했다고 표시
        
        for (int i : list[x]) {
            if(!visited[i]) { // 탐색하지 않았다면
                parents[i] = x; // 부모 노드를 입력
                dfs(i); // dfs 탐색
            }
        }
    }
}