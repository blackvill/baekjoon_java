package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_9205 {
	static int T;
	static int n;
	static int[][] xy; 
	static boolean[][] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			xy = new int[n + 2][2]; // 각 지점의 x, y축 좌표를 저장할 배열 
			check = new boolean[n + 2][n + 2]; // 각 지점을 
			
			// 각 지점의 좌표값을 입력
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				xy[i][0] = Integer.parseInt(st.nextToken()); // x값을 받음
				xy[i][1] = Integer.parseInt(st.nextToken()); // y값을 받음
			}
			
			// 각 좌표를 이용해 거리를 계산
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					int dist = Math.abs(xy[i][0] - xy[j][0]) + Math.abs(xy[i][1] - xy[j][1]);
					// 거리를 구해준다.
					if (dist <= 50 * 20) // 거리가 (50m * 맥주 수량)이내
						check[i][j] = true; // 참으로 표시
				}
			}
			
			// 모든 지점을 가는데의 최소 거리를 계산
			// 해당 문제에서는 거리값으로 계산을 하지 않고 true/false를 이용해 갈 수 있는지 없는지 판단
			for (int k = 0; k < n + 2; k++) { // 경유지
				for (int i = 0; i < n + 2; i++) { // 출발지
					if (i == k) continue;
					for (int j = 0; j < n + 2; j++) { // 도착지
						if (j == k || j == i)
							continue;
						if (check[i][k] == true && check[k][j]) {
							// i > k로 경유해서 가는 경우에 true
							// k > j로 경유해서 가는 경우에 true
							// 즉 i에서 k를 거쳐 j를 도착할 때에도 맥주가 부족하지 않다.
							check[i][j] = true; // 참으로 표시
						}
					}
				}
			}
			
			if (check[0][n + 1] == true)
				// 0 > n+1지점 (집에서 페스티벌까지 true라면)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}