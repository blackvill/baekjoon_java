package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14891 {
	static int wheel[][] = new int[4][8]; // 톱니바퀴 저장
	static int k; // 회전 횟수
	static int ans; // 결과
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			
			// 톱니바퀴의 초기 상태 입력
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 회전시킨 톱니바퀴의 번호
			int idx = Integer.parseInt(st.nextToken()) - 1;
			// 방향 - 1 시계, -1 반시계
			int dir = Integer.parseInt(st.nextToken());
			
			simul(idx, dir);
		}
		
		// 톱니바퀴의 12시가 1인지 확인해서 1인 경우 점수증가
		// 점수는 1 2 4 8로 2의 제곱으로 증가해서 Math.pow를 사용해 추가해주었다.
		for (int i = 0; i < 4; i++) {
			if (wheel[i][0] == 1)
				ans += Math.pow(2, i);
		}
		
		// 결과 출력
		System.out.println(ans);
	}
	
	// 회전시킨 톱니를 기준으로 좌우의 톱니 회전유무 확인
	static void simul(int index, int direction) {
		// 왼쪽 톱니
		left(index - 1, -direction);
		// 오른쪽 톱니
		right(index + 1, -direction);
		// 회전
		rotate(index, direction);
	}
	
	static void left(int index, int direction) {
		// 첫번째 톱니면 탈출
		if (index < 0)
			return;
		
		// 현재 톱니의 2번과 바로 오른쪽에 있는 톱니의 6번이 같으면 회전하지 않으니까
		// 다른 경우 회전
		if (wheel[index][2] != wheel[index + 1][6]) {
			// 다음 톱니바퀴를 확인
			left(index - 1, -direction);
			// 회전을 시킨다.
			rotate(index, direction);
		}
	}
	
	static void right(int index, int direction) {
		// 4번째 톱니면 탈출
		if (index > 3)
			return;
		
		// 현재 톱니의 6번과 바로 왼쪽의 톱니의 2번이 다르면
		if (wheel[index][6] != wheel[index - 1][2]) {
			// 다음 톱니바퀴를 확인
			right(index + 1, -direction);
			// 회전시킨다.
			rotate(index, direction);
		}
	}
	
	static void rotate(int index, int direction) {
		int temp = 0; // 임시변수
		
		// 방향이 1이면 시계 방향으로 회전
		if (direction == 1) {
			temp = wheel[index][7]; // 마지막 > 0번으로 이동해야 하므로 저장해둔다.
			
			// 한 칸씩 이동한다.
			for (int i = 7; i > 0; i--) {
				wheel[index][i] = wheel[index][i - 1];
			}

			// 0 번에 넣어주기
			wheel[index][0] = temp;
		}
		else { // 반시계 방향으로 회전
			temp = wheel[index][0]; // 0번 > 마지막으로 이동해야 하므로 저장해둠

			// 한 칸씩 이동한다.
			for (int i = 0; i < 7; i++) {
				wheel[index][i] = wheel[index][i + 1];
			}
			
			// 7번(마지막)에 넣어주기
			wheel[index][7] = temp;
		}
	}
}
