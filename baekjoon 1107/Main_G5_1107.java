package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_1107_김재욱 {
	static int n;
	static int m;
	static boolean[] broken = new boolean[10]; // 0 ~ 10
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		m = Integer.parseInt(br.readLine()); // 고장난 버튼의 갯수
		
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				broken[num] = true; // 고장버튼이면 true 체크
			}
		}

		// 모든 버튼이 고장났을 경우 +,-로만 이동한다고 가정하고 초기값을 잡아주기
		int ans = Math.abs(n - 100); // 초기 채널 100

		for (int i = 0; i < 1000000; i++) {
			int c = i;
			int len = check(c);
			
			// 이동한 번호에서 +,-를 몇 번을 눌러서 이동할 수 있는지 구하기
			if (len > 0) {
				int cnt = Math.abs(c - n);
				// 최소값 갱신
				ans = Math.min(ans, len + cnt);
			}
		}
		
		System.out.println(ans);
	}

	static int check(int c) {
		if (c == 0) { // 0번일 경우
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		
		int len = 0;
		
		// 한 자리씩 고장난 버튼인지 체크
		while (c > 0) {
			if (broken[c % 10]) { // 고장난 버튼이면
				return 0; // 불가능 하므로 리턴 0
			}
			len += 1; // 아니면 길이를 1 증가
			c /= 10; // 그 다음을 체크하기 위한 c를 10으로 나눠줌
		}
		
		return len;
	}
}