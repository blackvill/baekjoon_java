package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S4_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1 ; i <= n; i++)
			q.offer(i);
		
		while (q.size() > 1) {
			q.poll();
			int num = q.poll();
			q.offer(num);
		}
		System.out.println(q.poll());
	}
}