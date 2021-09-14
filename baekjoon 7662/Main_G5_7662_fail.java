package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_7662_fail {
	static int tc;
	static int k;
	static PriorityQueue<Integer> que;
	static PriorityQueue<Integer> rev_que;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			k = Integer.parseInt(br.readLine());
			
			que = new PriorityQueue<Integer>();
			rev_que = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (str.equals("I")) {
					que.offer(num);
					rev_que.offer(num);
					continue;
				}
				else if (str.equals("D")) {
					if (que.size() < 1)
						continue;
					if (num > 0) {
						int del = rev_que.poll();
						que.remove(del);
						continue;
					}
					else {
						int del = que.poll();
						rev_que.remove(del);
						continue;
					}
				}
			}
			if (que.isEmpty()) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(rev_que.poll()).append(" ").append(que.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}