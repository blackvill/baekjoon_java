package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2003_김재욱 {
	static int n;
	static int m;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 투포인터
		int left = 0; // 왼쪽 포인터
		int right = 0; // 오른쪽 포인터
		int len = arr.length;
		int sum = 0;
		
		while(left <= right) {
			if(sum >= m) {
				sum -= arr[left];
				left++;
			}
			else if(right >= len) {
				break;
			}
			else {
				sum += arr[right];
				right++;
			}
			
			// 주어진 값과 합이 같다면
			if(sum == m) {
				cnt++; // 횟수 증가
			}
		}
		
		System.out.println(cnt);
	}
}