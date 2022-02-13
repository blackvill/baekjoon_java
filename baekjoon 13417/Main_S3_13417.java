package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_S3_13417 {
	static int T;
	static int n;
	static Deque<String> dq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			br.readLine();

			dq = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String s = st.nextToken();

				if(dq.isEmpty()) {
					dq.add(s);
				}
				else {
					if(dq.getFirst().compareTo(s) >= 0) {
						dq.addFirst(s);
					}
					else {
						dq.addLast(s);
					}
				}
			}
			
			while(dq.size() != 0) {
				sb.append(dq.poll());
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
