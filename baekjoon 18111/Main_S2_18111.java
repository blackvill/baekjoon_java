package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_18111 {
	static int n, m, b;
	static int[][] map;
	static int max = Integer.MIN_VALUE; // 입력 시 주어지는 최고 층수
	static int min = Integer.MAX_VALUE; // 입력 시 주어지는 최저 층수
	static int time = Integer.MAX_VALUE; // 땅을 고르는데 걸리는 시간
	static int height = 0; // 땅을 고르고 났을 때 가장 높은 층수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 값 입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 최고 층수 구하기
				max = Math.max(map[i][j], max);
				// 최저 층수 구하기
				min = Math.min(min, map[i][j]);
			}
		}

		// 땅을 고를 때 최저 층수와 최고 층수 사이 값으로 되므로 이 값 사이를 반복으로 돌리면 된다.
		for (int k = max; k >= min; k--) {
			int t = 0; // 현재 층수로 땅을 고르는데 걸리는 시간
			int item = b; // 땅을 골랐을 때 나온 총 아이템 양
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 층수가 원하는 층수보다 높으면
					if (map[i][j] > k) {
						// 블록을 제거해서 인벤토리에 넣기
						// 땅을 고르는데 걸리는 시간은 2초
						item += (map[i][j] - k);
						t += 2 * (map[i][j] - k);
					}
					else if (map[i][j] < k) {
						// 인벤토리에서 블록을 꺼내기
						// 땅을 고르는데 걸리는 시간은 1초
						item -= (k - map[i][j]);
						t += (k - map[i][j]);
					}
				}
			}
//			System.out.println("결과 : " + k + " " + t + " " + item);
			
			// 역순으로 탐색하고 있기때문에
			// 같은 시간일 경우는 그냥 넘어가도록 처리해주면
			// 시간이 짧은 게 여럿일 경우 최고 높은 층수를 출력하는 조건 무시
			// 인벤토리에 블록이 남아 있으면 문제없이 땅을 고를 수 있다는 뜻
			// 시간이 더 적은 경우
			if (item >= 0 && time > t) { 
				height = k; // 높이 갱신
				time = t; // 시간 갱신
			}
		}
		
		System.out.println(time + " " + height);
	}
}
