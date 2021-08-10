package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_15650 {
	static int[] arr;
	static int N, M;
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[M];
        
		comb(1, 0);
	}
 
	public static void comb(int start, int cnt) {
		if (cnt == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}
}