package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S2_23029 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = map[0];
		// 음식을 연속으로 먹으면 2번째에 먹는 음식은 절반만 먹는다.
		// 하지만 음식을 먹을때 이전 음식이 0일 경우가 발생하므로 이를 따로 처리해야한다.
		if (n >= 2)
			// 음식이 0일 때
			if (map[0] == 0)
				dp[1] = map[0] + map[1];
			else
				dp[1] = map[0] + (map[1] / 2);
		if (n >= 3)
			// 음식이 0일 때는 이후에 먹는 음식을 절반만 먹을 필요가 없다.
			if (map[1] == 0)
				dp[2] = Math.max(dp[1], Math.max(dp[0] + map[2], map[1] + map[2]));
			// 이전 음식을 먹은 경우이므로 다음 음식은 절반만 먹는다.
			else
				dp[2] = Math.max(dp[1], Math.max(dp[0] + map[2], map[1] + (map[2] / 2)));
		if (n >= 4)
			for (int i = 3; i < n; i++) {
				// 이전에 먹은 음식이 0이라서 못먹는 경우
				if (map[i - 1] == 0)
					dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + map[i], dp[i - 3] + (map[i - 1] / 2) + map[i]));
				// 0이 아니라서 먹은 경우
				else
					dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + map[i], dp[i - 3] + map[i - 1] + (map[i] / 2)));
			}
		
		System.out.println(dp[n - 1]);
	}
}