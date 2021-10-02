package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G3_1167 {
	static int v;
	static ArrayList<Node>[] list;
	static boolean visited[];
	static int max;
	static int node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		v = Integer.parseInt(br.readLine());
		list = new ArrayList[v + 1];
		
		for (int i = 0; i < v + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());

			while (true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1)
					break;

				int w = Integer.parseInt(st.nextToken());
				list[s].add(new Node(e, w));
			}
		}

		//임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
		visited = new boolean[v + 1];
		dfs(1, 0);

		//node에서 부터 가장 먼 노트까지의 거리를 구한다.
		visited = new boolean[v + 1];
		dfs(node, 0);

		System.out.println(max);
	}

	public static void dfs(int x, int len) {
		if(len > max) {
			max = len;
			node = x;
		}
		visited[x] = true;

		for(int i = 0; i < list[x].size(); i++) {
			Node v = list[x].get(i);
			if(visited[v.e] == false) {
				dfs(v.e, v.cost + len);
				visited[v.e] = true;
			}
		}
	}

	public static class Node {
		int e;
		int cost;

		public Node(int e, int cost) {
			this.e = e;
			this.cost = cost;
		}
	}
}