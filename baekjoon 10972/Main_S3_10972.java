package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_10972 {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		nextPermutation(arr);
	}

	// 넥퍼
	private static void nextPermutation(int[] arr) {
		int n = arr.length;
		boolean b = true;

		Loop1:
		for (int i = n - 1; i > 0; i--) {
			// 현재 위치보다 이전 위치의 값이 작다면
			if (arr[i - 1] < arr[i]) {
				// 이전 위치들을 탐색해
				for (int j = n - 1; j >= i; j--) {
					// 더 큰 값이 있다면 서로 위치 교환
					if (arr[j] > arr[i - 1]) {
						int temp = arr[j];
						arr[j] = arr[i - 1];
						arr[i - 1] = temp;
						
						int k = n - 1;
						// 다 뒤집는다
						while (i < k) {
							int temp2 = arr[i];
							arr[i] = arr[k];
							arr[k] = temp2;
							i++;
							k--;
						}
						
						b = false;
						// 반복문 탈출
						// 다음 순열을 구했으니까
						break Loop1;
					}
				}
			}
		}
		// 마지막일 경우
		if (b) {
			System.out.print(-1);
		} else {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}