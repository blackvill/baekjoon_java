package BOJ_silver;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main_S2_14241 {
	static int n;
	static int[] arr;
	static int score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		// 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(arr);
		
		// 뒤에서부터 사용
		for (int i = n - 2; i >= 0; i--) {
			// 점수를 더해준다.
			score += arr[i] * arr[i + 1];
			// 커진 슬라임의 크기를 저장해준다.
			arr[i] = arr[i] + arr[i + 1];
		}
		
		// 점수를 출력한다.
		System.out.println(score);
	}
}