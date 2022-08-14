package BOJ_gold;

import java.io.*;
import java.util.*;

public class Main_G5_14719 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[w];
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < w - 1; i++) {
			int now = arr[i]; //현재 높이
			int left = now; //왼쪽 벽 최대높이
			int right = now; //오른쪽 벽 최대높이
			
			// 현재 위치 왼쪽에 더 큰 벽이 있는지 찾기
			for (int k = i - 1; k >= 0; k--) {
				if (arr[k] > now) {
					left = Math.max(left, arr[k]);
				}
			}
			
			// 현재 위치 오른쪽에 더 큰 벽이 있는지 찾기
			for (int k = i + 1; k < w; k++) {
				if (arr[k] > now) {
					right = Math.max(right, arr[k]);
				}
			}
			
			// 양쪽의 벽이 현재 높이보다 높으면
			if (left > now && right > now) {
				// 왼쪽이나 오른쪽 벽의 최소 높이에 현재 높이만큼을 빼서 결과에 더해준다.
				answer += (Math.min(left, right) - arr[i]);
			}
		}
		
		// 결과 출력하기
		System.out.println(answer);
	}
}