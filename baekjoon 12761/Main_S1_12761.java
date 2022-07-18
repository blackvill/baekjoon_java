package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S1_12761 {
	static int n, m;
	static int a, b;
	static int[] map;
	static int max = 100000; // 최대 범위

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[max + 1];
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		
		while (!q.isEmpty()){
			int pos = q.poll();
			
			// 동규의 현재위치가 주미의 위치라면 종료
			if (pos == m) {
				System.out.println(map[m]);
				return;
			}
			// -1칸 이동
			if (pos - 1 >= 0 && map[pos - 1] == 0) {
				map[pos - 1] = map[pos] + 1;
				q.offer(pos - 1);
			}
			// +1칸 이동
			if (pos + 1 <= max && map[pos + 1] == 0) {
				map[pos + 1] = map[pos] + 1;
				q.offer(pos + 1);
			}
			// -a칸 이동
			if (pos - a >= 0 && map[pos - a] == 0) {
				map[pos - a] = map[pos] + 1;
				q.offer(pos - a);
			}
			// +a칸 이동
			if (pos + a <= max && map[pos + a] == 0) {
				map[pos + a] = map[pos] + 1;
				q.offer(pos + a);
			}
			// -b칸 이동
			if (pos - b >= 0 && map[pos - b] == 0) {
				map[pos - b] = map[pos] + 1;
				q.offer(pos - b);
			}
			// +b칸 이동
			if (pos + b <= max && map[pos + b] == 0) {
				map[pos + b] = map[pos] + 1;
				q.offer(pos + b);
			}
			// a배 이동
			if (pos * a <= max && map[pos * a] == 0) {
				map[pos * a] = map[pos] + 1;
				q.offer(pos * a);
			}
			// b배 이동
			if (pos * b <= max && map[pos * b] == 0) {
				map[pos * b] = map[pos] + 1;
				q.offer(pos * b);
			}
		}
	}
}