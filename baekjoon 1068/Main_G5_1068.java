package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G5_1068 {
	static int n;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 루트 노드의 값을 담아준다.
			if (num == -1) {
				root = i;
				continue;
			}
			
			// 해당 리스트에 몇번째 값인지를 담음
			list[num].add(i);
		}
		
		int remove = Integer.parseInt(br.readLine());
		
		// 루트를 지우면 아무것도 없기때문에 탐색을 하지 않고 바로 출력해준다.
		if (remove == root)
			System.out.println(0);
		else {
			remove(remove); // 노드 제거
			System.out.println(leafCount(root)); // 리프노드 개수 구하기
		}
	}
	
	// 노드 지우기
	static void remove(int node) {
		// 자식이 있으면
		if (list[node].size() > 0) {
			int size = list[node].size();
			
			while (size > 0) {
				int child = list[node].get(--size);
				remove(child);
			}
		}
		
		// 자식 노드 제거
		for (int i = 0; i < n; i++) {
			// 노드에 연결되어있으면
			if (list[i].contains(node)) {
				for (int j = 0; j < list[i].size(); j++) {
					// 해당 노드라면
					if (list[i].get(j) == node) {
						list[i].remove(j); // 노드 제거
					}
				}
			}
		}
	}
	
	// 리프노드 개수 세기
	static int leafCount(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int pos = q.poll();
			
			// 연결된 것이 없으면
			if (list[pos].size() == 0) { 
				cnt++; // 개수 증가
				continue;
			}
			
			// 해당 노드에 연결된 모든 노드들을
			for (int next : list[pos]) {
				q.add(next); // 큐에 담아서 추가 탐색
			}
		}
		return cnt;
	}
}
