package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_2580 {
	public static int[][] map = new int[9][9]; // 스도쿠 입력을 담을 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받기
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
	}

	public static void dfs(int r, int c) {
		// 해당 행을 다 채웠다면 다음 행의 0번째부터 탐색을 해야한다.
		if (c == 9) {
			dfs(r + 1, 0);
			return;
		}

		// 모든 행과 열이 다 채워졌다면 결과를 출력한다.
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			// 프로그램을 종료한다.
			System.exit(0);;
		}

		// 현재 위치에 값이 0이라면 빈칸이니까 입력을 해주어야 한다
		if (map[r][c] == 0) {
			// 1~9까지의 수가 들어갈 수 있다.
			for (int i = 1; i < 10; i++) {
				// 입력할려는 값이 들어갈 수 있는지를 체크한다.
				if (check(r, c, i)) { // 가능하다면
					// 해당 위치를 i로 입력해주고
					map[r][c] = i;
					// 다음 탐색을 한다.
					dfs(r, c + 1);
				}
			}
			// 만약 1~9까지의 수를 모두 탐색했는데 불가능 하다면
			// 이전 위치에서 이미 잘못되었다는 것이니까
			// 현재 위치를 0으로 만들고 이전 위치로 돌아간다
			map[r][c] = 0;
			return;
		}
		else { // 해당 위치가 0이 아니라면 이미 값이 입력된 상태니까 다음으로 넘어간다
			dfs(r, c + 1);
		}
	}

	public static boolean check(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			// 행에 입력된 값이 있다면
			if (map[r][i] == num) {
				return false;
			}
			
			// 열에 입력된 값이 있다면
			if (map[i][c] == num) {
				return false;
			}
		}

		// 3*3 배열에서의 위치를 구하기 위해 (3으로 나눴을때 몫이 나오면 *3을 하게 되면 해당 위치의 시작)
		int box_r = r / 3;
		int box_c = c / 3;

		// 입력된 곳에서의 3*3 배열을 탐색해서 현재 입력된 값이 있다면 리턴 false
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[(box_r * 3) + i][(box_c * 3) + j] == num) {
					return false;
				}
			}
		}

		// 위에서 걸러지는게 없다면 가능한 숫자
		return true;
	}
}