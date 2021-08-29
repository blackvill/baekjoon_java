package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_6497 {
	
	static int n; // 길의 수
	static int m; // 집의 수
	static int[] parents; // 부모노드 확인용
	static boolean[] visited; // 방문처리용 배열
	static ArrayList<Edge> edge;
	static int mincount;
	static int cost; // 전체 비용
	
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;
		
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			parents = new int[n];
			mincount = 0;
			cost = 0;
			edge = new ArrayList<Edge>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edge.add(new Edge(start, end, weight));
				cost += weight; // 전체비용 구하기
			}
			
			Collections.sort(edge);
			
			makeSet();
			
			for (int i = 0; i < edge.size(); i++) {
				Edge e = edge.get(i);
				
				if (find(e.s) != find(e.e)) {
					mincount += e.w;
					union(e.s, e.e);
				}
			}
			System.out.println(cost - mincount);
			// 전체비용 - 최소 비용 = 절약된비용
		}
	}

	public static void makeSet() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
