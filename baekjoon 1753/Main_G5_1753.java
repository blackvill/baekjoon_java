package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1753 {
	
	static List<Node>[] list;
	
	public static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1. 데이터 입력 및 초기화
		int v = Integer.parseInt(st.nextToken()) + 1; // 정점의 개수
		int e = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		list = new ArrayList[v + 1];
		for (int i = 1; i < v; i++) {
            list[i] = new ArrayList<>();
        }
		int[] distance = new int[v]; 			// 정점 간의 최소 비용을 저장할 배열
		
		// 시작 정점
		int start = Integer.parseInt(br.readLine());
		
		// 정점에 대한 인접 정보 입력 받기
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()); // 시작
			int d = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 가중치
			list[u].add(new Node(d, w));
		}
		
		// 정점의 최소 비용을 갱신하기 위해 초기값을 max로 설정한다.
		Arrays.fill(distance, Integer.MAX_VALUE);
		// 시작 정점의 비용을 0으로 설정
		distance[start] = 0;
		
		// 2. 각 정점 수만큼 반복해서 최소 비용을 찾기
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0)); // 시작점과 가중치(자기 자신이니까 0)를 넣고 시작
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int vertex = node.vertex;
			int weight = node.weight;
			if (distance[vertex] < weight) // 이미 저장된 가중치보다 큰 가중치일 경우 비교할 필요가 없음
				continue;
			// 2.3 기존의 비용과 선택한 정점(경유지)을 통해 가는 비용 중 더 적은 비용으로 갱신
			for (int i = 0; i < list[vertex].size(); i++) {
				Node node2 = list[vertex].get(i); // 경유지
				int ver = node2.vertex; // 경유지의 정점
				int wei = node2.weight + weight; // 경유지까지 가는 weight + 경유지에서 가는 weight
				
				if (distance[ver] > wei) {		
					distance[ver] = wei;
					queue.add(new Node(ver, wei));
				}
			}
		}
		
		// 출력문
		for (int i = 1; i < v; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
}
