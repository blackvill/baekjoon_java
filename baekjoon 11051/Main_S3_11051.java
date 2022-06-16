package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S3_11051 {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력받기
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// 이항계수를 담기 위한 배열
		int[][] coefficient = new int[1001][1001];

		// 파스칼 삼각형
		// 점화식 : nCr = n-1Cr-1 + n-1Cr
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					coefficient[i][j] = 1;
				else
					coefficient[i][j] = (coefficient[i - 1][j - 1] + coefficient[i - 1][j]) % 10007;
			}
		}

		System.out.print(coefficient[n][k]);
	}
}