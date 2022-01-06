package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_2644 {
	static int n; // 전체 사람의 수
	static int m; // 부모 자식들 간의 관계의 개수
	static int ans = -1; // 촌수를 계산 불가능 할 경우 -1을 출력해야하므로 -1로 초기화를 해줌
	static boolean visited[];
	 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        n = Integer.parseInt(br.readLine());
 
        st = new StringTokenizer(br.readLine());
        int findX = Integer.parseInt(st.nextToken());
        int findY = Integer.parseInt(st.nextToken());
 
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }
 
        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 부모 자식간의 관계를 나타내는 두 번호
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            // 서로간의 관계를 저장
            a.get(x).add(y);
            a.get(y).add(x);
        }
 
        visited = new boolean[n + 1];
        
        // dfs 탐색
        DFS(a, visited, findX, findY, 0);
 
        // 출력
        System.out.println(ans);
    }
    
    // DFS를 이용하여 촌수 계산.
    public static void DFS(ArrayList<ArrayList<Integer>> a, boolean[] visited, int pos, int find, int cnt) {
        visited[pos] = true;
 
        for (int i : a.get(pos)) {
            if (!visited[i]) {
                if (i == find) { // 찾으려는 사람의 도달.
                    ans = cnt + 1;
                    return;
                }
 
                DFS(a, visited, i, find, cnt + 1);
            }
        }
    }
}