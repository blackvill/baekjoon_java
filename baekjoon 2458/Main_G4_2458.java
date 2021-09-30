package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 자신의 순위를 정확히 알기 위해선
 * 플루이드 와샬을 실행한 후
 * 자기 자신을 제외하고 나머지에 모두 값이 들어가있다면
 * 확인이 가능하다는 소리
 * 대신 x < y값만 입력받은 상태로 플루이드 와샬을 진행하기 때문에
 * 그냥 플루이드 와샬만 돌린 상태는 자신보다 큰 사람의 결과만 적힌다.
 * 따라서, 자신의 값과 타인이 보는 자신의 결과값으로 생각해야한다.
 */

public class Main_G4_2458 {
	static int n; // 학생들의 수
	static int m; // 비교 횟수
	static int student; // 자신의 순위를 알 수 있는 학생의 수
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		student = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			map[s][e] = 1;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][k] == 1 && map[k][j] == 1)
						map[i][j] = 1;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1 || map[j][i] == 1) {
					cnt++;
				}
			}
			if (cnt == n - 1)
				student++;
		}
		
		System.out.println(student);
	}
}
