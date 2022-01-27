package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_1996 {
	static char[][] map;
	static char[][] result;
	static int n;
	
	// 8방탐색을 하기 위한 델타 배열
	static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[] dc = {-1, 1, 0, 0, 1, -1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n]; // 지뢰 상태를 나타내기 위한 배열
		result = new char[n][n]; // 결과를 출력하기 위한 배열
		
		// 배열 입력받기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 만약 지뢰가 있는 곳이라면
				if (map[i][j] != '.') {
					result[i][j] = '*'; // *으로 입력
				}
				else {
					int cnt = 0; // 주변의 지뢰 갯수를 세기위한 변수
					
					// 8방 탐색
					for (int k = 0; k < 8; k++) {
						int nx = i + dr[k];
						int ny = j + dc[k];
						
						// 범위를 벗어나지 않고 map이 숫자인 경우
						if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != '.') {
							cnt += (map[nx][ny] - '0'); // 지뢰 갯수 추가
						}
					}
					// 지뢰 갯수가 10이 넘는다면
					if (cnt >= 10)
						result[i][j] = 'M'; // M으로 입력
					else // 아니라면
						result[i][j] = (char)(cnt + '0'); // 지뢰의 갯수를 입력
				}
			}
		}
		
		// 결과 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}