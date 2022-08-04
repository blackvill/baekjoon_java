package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G5_3020 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] bot = new int[h + 2];
		int[] top = new int[h + 2];

		// 해당 높이의 개수를 구하기
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			// 석순의 높이에 맞춰서 값 증가
			if (i % 2 == 0)
				bot[x]++;
			else // 종유석의 높이에 맞춰서 값 증가
				top[h - x + 1]++;
		}

		// 누적 합 구하기
		for (int i = 1; i <= h; i++) {
			bot[i] += bot[i - 1];
		}
		for (int i = h; i >= 1; i--) {
			top[i] += top[i + 1];
		}

		// 모든 장애물의 개수를 최소값으로 설정
		int min = n;
		int cnt = 0;

		for (int i = 1; i <= h; i++) {
			// 석순의 총 개수 - 현재 -1층의 석순의 개수
			int b_cnt = bot[h] - bot[i - 1];
			// 종유석의 총 개수 - 현재 +1층의 종유석의 개수
			int t_cnt = top[1] - top[i + 1];
			// 해당 높이의 종유석의 개수 + 석순의 개수
			int wall = b_cnt + t_cnt;

			// 장애물이 최소값보다 적으면 갱신
			if (wall < min) {
				min = wall;
				cnt = 1;
			}
			// 장애물의 최소값과 값이 같으면 개수가 동일한 구간
			else if (wall == min)
				cnt++;
		}

		System.out.println(min + " " + cnt);
	}
}
