package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_1966 {
	static int T;
	static int n;
	static int m;
	static Queue<Integer> q;
	static LinkedList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			list = new LinkedList<>();
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0; i < n; i++) {
				if (i == m)
					q.add(m);
				else
					q.add(101);
			}
			
			int count = 0;
			
			while (!q.isEmpty()) {
				boolean check = true;
				
				for (int i = 0; i < list.size(); i++) {
					if (list.peek() < list.get(i)) {
						check = false;
						break;
					}
				}
				
				if (!check) {
					list.add(list.poll());
					q.add(q.poll());
				}
				else {
					list.poll();
					count++;
					
					if (q.peek() == m)
						System.out.println(count);
					q.poll();
				}
			}
		}
	}

}
