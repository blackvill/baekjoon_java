package BOJ_gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G1_9576 {
	static int T;
	static int n;
	static int m;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Point[] points = new Point[m + 1];
			for (int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				points[i] = new Point(a, b);
			}

			// b를 기준으로 오름차순 정렬하되, b가 같을 경우
			// a를 기준으로 오름차순 정렬한다.
			Arrays.sort(points, 1, m + 1, (p1, p2) -> (p1.y == p2.y) ? p1.x - p2.x : p1.y - p2.y);

			ans = 0;
			boolean[] check = new boolean[n + 1];
			
			for (int i = 1; i <= m; i++) {
				int a = points[i].x;
				int b = points[i].y;

				// 해당하는 범위 내에서
				// 가능한 가장 작은 번호의 책부터 뽑는다.
				for (int j = a; j <= b; j++) {
					if (!check[j]) {
						check[j] = true;
						ans++;
						break;
					}
				}
			}
			
			sb.append(ans + "\n");
		}

		System.out.println(sb.toString());
	}
}