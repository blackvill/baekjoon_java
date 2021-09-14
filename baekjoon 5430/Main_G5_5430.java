package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G5_5430 {
	static int tc;
	static int n;
	static String func;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder("");
		
		point:
		for (int i = 0; i < TC; i++) {
			String func = br.readLine();
			boolean isReverse = false;
			int n = Integer.parseInt(br.readLine());
			
			Deque<Integer> deque = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			for (int j = 0; j < n; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			for (char c : func.toCharArray()) {
				if (c == 'R') {
					isReverse = !isReverse;
				} else {
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						continue point;
					}
					if (isReverse) {
						deque.removeLast();
					} else {
						deque.removeFirst();
					}
				}
			}
			sb.append("[");
			while (!deque.isEmpty()) {
				if (isReverse) {
					sb.append(deque.removeLast());
				} else {
					sb.append(deque.removeFirst());
				}
				if (!deque.isEmpty())
					sb.append(",");
			}
			sb.append("]").append("\n");
		}
		System.out.print(sb);
	}
}