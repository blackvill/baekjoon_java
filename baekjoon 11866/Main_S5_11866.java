package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S5_11866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<Integer> q = new LinkedList<Integer>();
		
		int n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		int m = Integer.parseInt(st.nextToken());
		System.out.print("<");
		
		while (q.size() != 1) {
			for (int i = 1; i < m; i++) {
				q.offer(q.peek());
				q.poll();
			}
			System.out.print(q.poll() + ", ");
		}
		System.out.println(q.poll() + ">");
	}
}