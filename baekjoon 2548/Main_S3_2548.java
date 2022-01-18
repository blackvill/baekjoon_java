package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_2548 {
	static int n;
	static int arr[];
	static int min;
	static int min_sum = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오른차순 정렬
		Arrays.sort(arr);
		
		// 브루트포스
		for (int i = 0; i < n; i++) {
			int sum = 0; // 각 순서에 차이합
			
			for (int j = 0; j < n; j++) {
				sum += Math.abs(arr[i] - arr[j]); // 차이합을 더하기
				
				// 만약 최소보다 값이 커진다면 탈출
				if (sum > min_sum)
					break;
				// 만약 for문을 다 돌았다면
				if (j == n - 1) {
					// 만약 sum이 최소합보다 작다면 갱신
					if (sum < min_sum) {
						min_sum = sum;
						min = arr[i];
					}
				}
			}
		}
		
		// 결과 출력
		System.out.println(min);
	}
}