package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17144 {
	static int r;
	static int c;
	static int t;
	static int[][] map;
	static int[][] countmap;
	static int bound; // 공기청정기를 기준으로 위 아래 나누기 위한 변수
	static int dust; // 먼지의 개수

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					bound = i; // i만 저장하는 이유는 무조건 1열에 설치되므로
			}
		}

		// t만큼 반복 시켜준다.
		for (int i = 0; i < t; i++) {
			diffusion(); // 확산시키고
			cleaner(); // 공기청정기 실행
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != -1)
					dust += map[i][j];
			}
		}
		
		System.out.println(dust);
	}

	public static void diffusion() {
		countmap = new int[r][c];
		// map에 바로 적용시키면 다른 곳에서 확산이 되고 난 후 5인 곳에서 확산이 발생할 수 있다.
		// 그를 막아주기 위한 countmap

		for (int i = 0 ; i < r; i++) {
			for (int j = 0; j < c; j++) {
				countmap[i][j] += map[i][j];
				// =이 아니라 +=인 이유는 이전에 확산된 값이 이미 countmap에 들어가 있을 수 있으므로 

				if (map[i][j] < 5) // 5보다 작으면 확산 불가
					continue;

				int diffcnt = map[i][j] / 5; // 확산되는 양은 5로 나눴을때의 몫

				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					// 공기청정기가 아니고, 범위 안에 들어간다면
					if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != -1) {
						countmap[nr][nc] += diffcnt; // 주변에는 증가시켜주고
						countmap[i][j] -= diffcnt; // 해당 좌표는 빠진 만큼 감소 시켜준다.
					}
				}
			}
		}

		// countmap에 저장된 값을 map으로 옮겨준다.
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = countmap[i][j];
			}
		}
	}

	public static void cleaner() {
		countmap = new int[r][c];
		// map에 바로 적용시키면 값이 누락되는 경우가 발생할 수도 있다.
		// 그를 막아주기 위한 countmap
		
		// map을 countmap에 복사
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				countmap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < 2; i++) {
			int cleaner_r = bound - i; // 공기청정기의 행 (처음엔 밑 부분, 다음은 윗부분)
			int cleaner_c = 0; // 공기청정기의 열은 항상 1

			// 오른쪽으로 쭉
			while (cleaner_c + 1 < c) {
				if (map[cleaner_r][cleaner_c] != -1) // 공기청정기가 아닐때 해야한다.
					countmap[cleaner_r][cleaner_c + 1] = map[cleaner_r][cleaner_c];
				else // 공기청정기라면 해당 위치를 0으로 만들어 준다.
					countmap[cleaner_r][cleaner_c + 1] = 0;
				cleaner_c++;
			}

			// 아래로 or 위로
			if (i == 0) {
				while (cleaner_r + 1 < r) {
					countmap[cleaner_r + 1][cleaner_c] = map[cleaner_r][cleaner_c];
					cleaner_r++;
				}
			}
			else if (i == 1) {
				while (cleaner_r > 0) {
					countmap[cleaner_r - 1][cleaner_c] = map[cleaner_r][cleaner_c];
					cleaner_r--;
				}
			}

			// 왼쪽으로 쭉
			while (cleaner_c > 0) {
				countmap[cleaner_r][cleaner_c - 1] = map[cleaner_r][cleaner_c];
				cleaner_c--;
			}
			// 위로 or 아래로
			if (i == 0) {
				while (cleaner_r > bound - 1) {
					countmap[cleaner_r - 1][cleaner_c] = map[cleaner_r][cleaner_c];
					cleaner_r--;
				}
			}
			else if (i == 1) {
				while (cleaner_r + 1 < bound) {
					countmap[cleaner_r + 1][cleaner_c] = map[cleaner_r][cleaner_c];
					cleaner_r++;
				}
			}
		}
		
		// countmap을 map에 복사
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == -1) // 공기청정기 위치면 건너뛰기
					continue;
				map[i][j] = countmap[i][j];
			}
		}
	}
}
