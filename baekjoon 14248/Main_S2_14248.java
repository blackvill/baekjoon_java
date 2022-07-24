package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_14248 {
	static int n, s, cnt;
	static int[] map;
	static boolean[] visited;
	
	// 왼쪽과 오른쪽으로만 탐색
	static int[] dr = {-1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n];
		visited = new boolean[n];
		
		// 값 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		// 입력받기 -> 배열에서 처리할꺼니까 -1해줌
		s = Integer.parseInt(br.readLine()) - 1;
		
		bfs(s);
		
		System.out.println(cnt);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);

		// 시작지점 방문
		visited[x] = true; 
		cnt = 1;
		
		while (!q.isEmpty()) {
			int pos = q.poll();
			
			for (int i = 0; i < 2; i++) {
				// 현재 위치 + 현재 위치의 돌에 적힌 값 (좌우로 이동하기 위해 dr의 값을 곱해줌)
				int nx = pos + (map[pos] * dr[i]);
				
				// 돌다리 벗어나는 경우
				if (nx < 0 || nx >= n)
					continue;
				// 이미 방문한 경우
				if (visited[nx])
					continue;
				
				q.add(nx);
				visited[nx] = true; // 방문처리
				cnt++; // 방문한 돌다리 횟수 증가
			}
		}
	}
}