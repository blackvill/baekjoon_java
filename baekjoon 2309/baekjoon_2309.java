package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2309 {

	static int[] height = new int[7];
	static int[] input = new int[9];
	static int n = 9, r = 7;
	static int sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < n; i++)
			input[i] = sc.nextInt();
		
		height = new int[r];
		combination(n, r);
	}
	private static void combination (int n, int r) {
		if (r == 0) { // 조합의 요소를 모두 뽑은 경우
			if (sum == 100) {
				for (int i = 0; i < height.length; i++)
					System.out.println(height[i]);
			}
			return;
		}
		if (n < r) return; // n이 r보다 커지면
		// 선택
		height[r - 1] = input[n - 1];
		sum += input[n - 1];
		combination(n - 1, r - 1);
		// 비 선택
		sum -= input[n - 1];
		combination(n - 1, r);
	}
	
}
