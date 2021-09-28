package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * zero
 * one
 * two
 * three
 * four
 * five
 * six
 * seven
 * eight
 * nine
 * 
 * 8 5 4 9 1 7 6 3 2 0 순서
 */


public class Main_S4_1755 {
	static int n;
	static int m;
	static int[][] sort;
	static int[] arr;
	static int[] line = {8, 5, 4, 9, 1, 7, 6, 3, 2, 0};
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[101];
		sort = new int[10][10];
		
		for (int i = m; i <= n; i++) {
			int k = arr[i] = i;
			
			if (arr[i] < 10) {
				sort[0][i]++;
			}
			else {
				int num = arr[i] % 10;
				k = arr[i] / 10;
				int mod = k % 10;
				sort[mod][num]++;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (sort[0][line[i]] == 1) {
				System.out.print(line[i] + " ");
				count++;
				if (count % 10 == 0)
					System.out.println();
			}
			for (int j = 0; j < 10; j++) {
				if (sort[line[i]][line[j]] == 1) { // 순서에 맞게 나온다면
					System.out.print(line[i] * 10 + line[j] + " "); // 값 출력
					count++; // 카운트 증가
					if (count % 10 == 0)
						System.out.println();
				}
			}
		}
	}
}