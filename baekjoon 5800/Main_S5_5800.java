package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_5800 {
	static int k;
	static int n;
	static int[] arr;
	static int gap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 반의 수
		k = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 반의 학생 수
			int n = Integer.parseInt(st.nextToken());
			
			// 초기화
			arr = new int[n];
			gap = 0;
			
			// 입력받기
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			// 배열을 오름차순으로 정렬하기
			Arrays.sort(arr);
			
			// 인접하는 값의 차이를 구하기 위해 0~n-1까지 탐색을 하면서 다음값 - 현재값으로 차이가 가장 큰 것을 구했다.
			for (int j = 0; j < n - 1; j++) {
				gap = Math.max(gap, arr[j + 1] - arr[j]);
			}
			
			// 출력
			System.out.println("Class " + i);
			System.out.println("Max " + arr[n - 1] + ", Min " + arr[0] + ", Largest gap " + gap);
		}
	}
}
