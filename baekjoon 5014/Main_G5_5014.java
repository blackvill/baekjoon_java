package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_G5_5014 {
	static int f, s, g;
	static int ele[] = new int[2]; // 엘레베이터
	static int move[]; // 이동 횟수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken()); // 건물 총 층수
		s = Integer.parseInt(st.nextToken()); // 현재 층
		g = Integer.parseInt(st.nextToken()); // 목표 층
		ele[0] = Integer.parseInt(st.nextToken()); // 위로 올라가는 칸수
		ele[1] = Integer.parseInt(st.nextToken()) * -1; // 아래로 내려가는 칸수
		
		move = new int[f + 1];
		
		bfs(s);
	}

	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[f + 1]; // 방문처리용 배열
		
		q.offer(s);
		visited[s] = true; // 방문처리
		move[s] = 0; // 시작지점은 0
		
		while (!q.isEmpty()) {
			int pos = q.poll();
			// 현재 위치와 목표 층수가 같으면 결과 출력
			if (pos == g) {
				System.out.println(move[pos]);
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				// 다음 위치
				int ns = pos + ele[i]; 
				
				// 최대 층수보다 위거나 1층보다 아래인 경우
				if (ns > f || ns < 1)
					continue;
				
				// 방문하지 않았다면
				if (!visited[ns]) {
					// 방문처리, 이동 증가, 추가 탐색을 위해 큐에 삽입
					visited[ns] = true;
					move[ns] = move[pos] + 1;
					q.offer(ns);
				}
			}
		}
		
		// 도착하지 못한다면
		System.out.println("use the stairs");
	}
}