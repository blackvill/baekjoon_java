package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1940 {
	static int n;
	static int m;
	static int[] arr;
	static int count; // 만들 수 있는 갑옷의 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n, m 입력받기
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		// 재료 번호 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// arr을 정렬
		Arrays.sort(arr);
		
		// 왼쪽 포인터, 오른쪽 포인터
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			// 합이 m과 같다면 갑옷을 만들 수 있다. (똑같은 재료 사용불가)
			if (arr[left] + arr[right] == m) {
				count++; // 갑옷의 수를 증가시켜주고
				left++; // 왼쪽은 증가
				right--; // 오른쪽은 감소
			}
			// 합이 작다면 왼쪽을 증가
			else if (arr[left] + arr[right] < m) {
				left++;
			}
			// 합이 크다면 오른쪽을 감소
			else {
				right--;
			}
		}
		
		// count 출력
		System.out.println(count);
	}

}
