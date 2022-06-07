package BOJ_gold;

import java.util.*;
import java.io.*;

public class Main_G4_14002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int map[] = new int[n + 1];
		int dp[] = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 값 채워주기
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 1;
		// 최장길이, 최단길이를 구할 때 처럼 문제를 풀면 된다.
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (map[i] > map[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					result = Math.max(dp[i], result);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// 최고 길이 저장
		sb.append(result + "\n");
		
		// 스택을 사용해 최장 길이의 원소들을 담아줄 것
		Stack<Integer> s = new Stack<>();
		// 역순으로 탐색
		for(int i = n; i > 0; i--) {
			// 최장 길이와 해당 dp 값이 같다면
			if(dp[i] == result) {
				// 해당하는 원소의 값을 스택에 담아주기
				s.push(map[i]);
				// 하나의 원소를 담아줬으므로 길이 -1
				result--;
			}
		}
		
		// 스택에 있는 값들을 다 스트링빌더에 담아주기
		while(!s.isEmpty()) {
			sb.append(s.pop() + " ");
		}
		
		System.out.println(sb.toString());
	}
}