package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Main_S2_1260 {
	static int n;
	static int m;
	static int v;
	static int[][] adj;
	static boolean[] visited; // 방문 확인 여부
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		adj = new int[1001][1001];
		visited = new boolean[1001];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start][end] = 1;
			adj[end][start] = 1;
		}
		dfs(v);
		System.out.println();
		visited = new boolean[1001];
		bfs(v);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");;
		
		for (int i = 1; i <= n; i++) {
			if (adj[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		visited[start] = true;
		System.out.print(start + " ");
		
		while(!queue.isEmpty()) {
		      int temp = queue.poll();
		      
		      for(int i = 1; i <= n; i++) {
		        if(adj[temp][i] == 1 && visited[i] == false) {
		          queue.offer(i);
		          visited[i] = true;
		          System.out.print(i + " ");
		        }
		      }
		    }
	}
}