package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2563 {
	static int x;
	static int y;
	static int sum;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[100][100];
		// 배열 초기화
		sum = 0;
		int n = Integer.parseInt(br.readLine());
		// 입력받은 n만큼 반복 시킬거임
		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (arr[x + i][y + j] == 0) { // 색종이를 붙이는 면적에 이미 색종이가 있는지 확인
						arr[x + i][y + j] = 1; // 없으면 1로 바꿔줌
						sum++; // 합++
					}
				}
			}
		}
		System.out.println((sum));
	}
}