package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_6159 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		int[] map = new int[n];
		// 입력 받기
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		// 배열 정렬하기
		Arrays.sort(map);
		
		// 배열을 탐색하면서 합이 s보다 작은것 개수 찾기
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (map[i] + map[j] <= s)
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}