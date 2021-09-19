package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1916 {
	static int n;
	static int m;
    static ArrayList<ArrayList<Node>> list; // 인접리스트.
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.

	public static class Node implements Comparable<Node> {
	    int end;
	    int weight;
	 
	    Node(int end, int weight) {
	        this.end = end;
	        this.weight = weight;
	    }
	 
	    @Override
	    public int compareTo(Node o) {
	        return weight - o.weight;
	    }
	}
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
 
        list = new ArrayList<>();
        dist = new int[n + 1];
        check = new boolean[n + 1];
 
        Arrays.fill(dist, Integer.MAX_VALUE);
 
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
 
        // 단방향 인접 리스트 구현.
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
 
            // start에서 end로 가는 weight (가중치)
            list.get(start).add(new Node(end, weight));
        }
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        System.out.println(dijkstra(s, e));
    }
 
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;
 
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;
 
            if (!check[cur]) {
                check[cur] = true;
 
                for (Node node : list.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
