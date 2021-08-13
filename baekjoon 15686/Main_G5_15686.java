package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main_G5_15686 {
	static int n;
	static int m;
	static int[][] map;
	static Point[] visited;
	static ArrayList<Point> chicken = new ArrayList<>(); 
    static ArrayList<Point> home = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				switch (n) { // 1이면 집, 2면 치킨집
				case 1 :
					home.add(new Point(i, j)); //집에 xy 등록
					break;
				case 2 :
					chicken.add(new Point(i, j)); // 치킨집에 xy 등록
					break;
				default :
					break;
				}
			}
		}
		visited = new Point[m]; // 방문 했는지 확인을 치킨집의 개수 만큼으로 설정
		comb(0, 0);
		System.out.println(result); // 결과값 출력
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == m) {
			int move = 0;
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) {
					// 집과 치킨집의 x y 좌표의 절대값을 구한다
					// 현재 이부분에서 무조건 0번째부터 가져오는 에러가 있음 이를 어캐 해결해야할까??
					move = Math.abs(home.get(i).x - visited[j].x) + Math.abs(home.get(i).y - visited[j].y);
					min = Math.min(min, move); // 치킨집과 집의 가장 최소값을 구한다.
				}
				sum += min; // 최소값을 더한다.
			}
			result = Math.min(result, sum); // 모든 최소값과 결과를 비교해서 더 작은것으로 적용한다.
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			visited[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1); //다음 탐색
		}
	}
}
