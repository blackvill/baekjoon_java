package BOJ_silver;
import java.util.Scanner;

public class Main_S2_11053 {
	// n값이 커지면 시간복잡도가 불리해진다
	// 시간 복잡도가 n^2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] LIS = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			LIS[i] = 1;
			
			for (int j = 0; j < i; j++) { // j : i의 앞쪽 원소들
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
									// i를 끝으로 하는 최장 길이 수열 < j를 끝으로 하는 최장길이 수열 + 1(i 자신의 길이)
					LIS[i] = LIS[j] + 1;
				}
			}
			if (max < LIS[i])
				max = LIS[i];
		}
		System.out.println(max);
	}
}