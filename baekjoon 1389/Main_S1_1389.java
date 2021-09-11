package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1389 {
	public static int n, m;
	public static int min = Integer.MAX_VALUE;
	public static int answer;
	public static int[][] map;
	public static boolean[] visited;
	public static int[] kevin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		kevin = new int[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = map[end][start] = 1;
		}
		
		for(int i = 1; i <= n; i++) {

			for(int j = 1; j <= n; j++) {
				visited = new boolean[n + 1];
				if(i == j) continue;
				visited[i] = true;
				kevin[i] += bfs(i,j);
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(min > kevin[i]) {
				min = kevin[i];
				answer = i;
			}
		}
		System.out.println(answer);
	}
	
	private static int bfs(int from, int to) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int j = 1; j <= n; j++) {
			if(map[from][j] == 1) {
				visited[j] = true;
				q.offer(j);
			}
		}
		int cnt = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int num = q.poll();
				if(num == to) {
					return cnt;
				}
				for(int j = 1; j <= n; j++) {
					if(visited[j] == true || map[num][j] == 0)
						continue;
					visited[j] = true;
					q.offer(j);
				}
			}
			cnt++;
		}
		return 0;
	}

}
