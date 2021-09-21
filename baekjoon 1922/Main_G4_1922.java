package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1922 {
	static int n;
	static int m;
	static int[] parents;
	static PriorityQueue<Node> pq;
	static int cost;
	
	public static class Node implements Comparable<Node> {
		int s;
		int e;
		int w;
		
		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		parents = new int[n + 1];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(start, end, weight));
		}
		
		makeSet();
		
		for (int i = 0; i < m; i++) {
			Node q = pq.poll();
			
			int start = q.s;
			int end = q.e;
			int weight = q.w;
			
			// 이 부분의 이유를 모르겠네;;;
			if (find(start) == find(end))
				continue;
			
			if (union(start, end));
				cost += weight;
		}
		
		System.out.println(cost);
	}

	public static void makeSet() {
		for (int i = 0; i <= n; i++)
			parents[i] = i;
	}
	
	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int a_Root = find(a);
		int b_Root = find(b);
		
		if (a_Root == b_Root)
			return false;
		
		parents[b_Root] = a_Root;
		return true;
	}
}
