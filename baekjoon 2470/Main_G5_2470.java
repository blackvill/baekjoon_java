package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2470_김재욱 {
	static int n;
	static int a; // 1번 용액
	static int b; // 2번 용액
	static int gap = Integer.MAX_VALUE; // 용액의 차이 (저장해두고 비교)
	static int sum; // 용액의 차이 (매번 갱신됨)
	static int arr[]; // 용액을 담을 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 용액 입력 받기
		for (int left = 0; left < n; left++) {
			arr[left] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(arr);
		
		// 왼쪽 포인터와 오른쪽 포인터
		int left = 0;
		int right = arr.length - 1;
		
		// 왼쪽이 오른쪽보다 커지면 종료시킨다. (== 서로 만나게 되면 종료된다.)
		while (left < right) {
			// 절대값으로 두 용액의 합을 구해준다.
			sum = Math.abs(arr[left] + arr[right]);
			// 저장되어 있는 용액의 차이보다 작다면 == 0에 가깝다면
			if (sum < gap) {
				// 갱신
				gap = sum;
				a = arr[left];
				b = arr[right];
			}
			// 합이 0보다 작다면 왼쪽포인터 이동, 아니면 오른쪽 포인터 이동
			// sum으로 처리 안하는 이유 : sum은 abs로 절대값이기 때문에 무조건 0이상이다.
			if (arr[left] + arr[right] < 0)
				left++;
			else
				right--;
		}
		
		System.out.println(a + " " + b);
	}
}