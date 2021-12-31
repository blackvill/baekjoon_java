package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_16435_김재욱 {
	static int n; // 과일의 개수
	static int l; // 초기 길이
	static int[] h; // 과일의 위치

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받기
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		h = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		// h를 오름차순으로 정렬
		Arrays.sort(h);
		
		for (int i = 0; i < n; i++) {
			// 스네이크버드보다 작거나 같으면 먹을 수 있음
			if (l >= h[i]) {
				l++; // 먹으면 길이 증가
			}
			// 아니면 못먹음
			else
				break;
		}
		
		// 스네이크 버드의 길이 출력
		System.out.println(l);
	}
}