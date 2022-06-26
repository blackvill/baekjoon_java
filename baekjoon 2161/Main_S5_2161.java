package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_2161 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		// n까지의 카드를 큐에 담아주기
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			// 큐의 가장 앞을 빼주고 StringBuilder에 담아주기
			sb.append(q.poll()).append(" ");
			
			// 큐가 비었다면 탈출
			if (q.isEmpty())
				break;
			
			// 큐의 가장앞을 빼서 마지막에 담아주기
			q.offer(q.poll());
		}
		
		// 결과를 출력
		System.out.println(sb.toString());
	}
}