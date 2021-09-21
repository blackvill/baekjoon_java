package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_21924 {
	static int n;
	static int m;
	static int[] parents;
	static long weights_all;
	static long cost;
	static int check;
	static PriorityQueue<Node> pq;

	public static class Node implements Comparable<Node> {
		int start;
		int end;
		long weight;

		public Node(int start, int end, long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return (int)(weight - o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<Node>();
		parents = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long w = Integer.parseInt(st.nextToken());

			pq.add(new Node(s, e, w));
			weights_all += w;
		}
		
		makeSet();

		for (int i = 0; i < m; i++) {
			Node q = pq.poll();
			
			int start = q.start;
			int end = q.end;
			long weight = q.weight;
			
			if (union(start, end))
				cost += weight;
		}
		
		for (int i = 1; i <= n; i++) {
			if (i > 1 && check != find(i))
				cost = -1;
			check = find(i);
		}
		
		if (cost == -1)
			System.out.println("-1");
		else
			System.out.println(weights_all - cost);
	}

	public static void makeSet() {
		for (int i = 0; i <= n; i++)
			parents[i] = i;
	}

	public static int find(int a) {
		if (parents[a] == a)
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