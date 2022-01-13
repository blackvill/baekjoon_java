package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_11497 {
	static int T;
	static int n;
	static int[] arr; // 입력받은 배열
	static int[] sorting; // 통나무 다리 배치한 상태의 배열
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			// 초기화
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			sorting = new int[n];
			min = 0;
			
			// 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 배열을 정렬
			Arrays.sort(arr);
			
			int left = 0; // 왼쪽 포인터
			int right = n - 1; // 오른쪽 포인터
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) { // 짝수라면 왼쪽
					sorting[left] = arr[i];
					left++;
				}
				else { // 홀수라면 오른쪽
					sorting[right] = arr[i];
					right--;
				}
			}
			
			// 처음과 끝의 차이를 min으로 초기화
			min = Math.abs(sorting[0] - sorting[n - 1]);
			
			// 이후 min값보다 더 큰 값이 존재하면 갱신
			for (int i = 1; i < n; i++) {
				min = Math.max(min, Math.abs(sorting[i] - sorting[i - 1]));
			}
			
			System.out.println(min);
		}
	}
}