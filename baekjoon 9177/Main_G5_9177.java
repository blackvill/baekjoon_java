package BOJ_gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_9177 {
	static int n;
	static char[] word1; // 1번 문자열
	static char[] word2; // 2번 문자열
	static char[] word3; // 3번 문자열
	static boolean result; // 결과

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			word1 = st.nextToken().toCharArray();
			word2 = st.nextToken().toCharArray();
			word3 = st.nextToken().toCharArray();
			
			result = false;

			// bfs 탐색
			bfs();
			
			// 출력부분
			System.out.print("Data set " + i + ": "); // 공통부분
			// 조건에 따라서 결과 출력
			if (result)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		boolean visited[][] = new boolean[word1.length + 1][word2.length + 1];
		
		q.add(new Point(0, 0));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			int a = p.x; // word1의 인덱스
			int b = p.y; // word2의 인덱스
			
			// 길이가 같으면 result는 true
			// (문자가 다를 경우 이후 탐색을 하지 않으므로 길이가 같으면 다 같은 것)
			if (a + b == word3.length) {
				result = true;
				break;
			}
			
			// 방문하지 않았고 a가 word1의 길이보다 짧고 word3의 a+b번째 문자가 word1의 a번째 문자와 일치하면
			if (a < word1.length && word3[a + b] == word1[a] && !visited[a + 1][b]) {
				// 해당 위치를 방문했음을 체크
				visited[a + 1][b] = true;
				// 다음 탐색을 위해 큐에 추가
				q.add(new Point(a + 1, b));
			}
			// 방문하지 않았고 b가 word2의 길이보다 짧고 word3의 a+b번째 문자가 word2의 b번째 문자와 일치하면
			if (b < word2.length && word3[a + b] == word2[b] && !visited[a][b + 1]) {
				// 해당 위치를 방문했음을 체크
				visited[a][b + 1] = true;
				// 다음 탐색을 위해 큐에 추가
				q.add(new Point(a, b + 1));
			}
		}
	}
}