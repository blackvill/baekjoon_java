package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *	
 *	1 2
 * 	3 4
 *  5 6 
 *  
 *  -1 -2 0
 *   0 0 3
 */

public class Main_B1_2740 {
	static int n; // arr1의 행
	static int m; // arr1의 열 , arr2의 행
	static int k; // arr2의 열
	static int[][] arr1; // n * m
	static int[][] arr2; // m * k
	static int[][] arr3; // n * k

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken());
		arr1 = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); 
		k = Integer.parseInt(st.nextToken());
		arr2 = new int[m][k];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr3 = new int[n][k];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int r = arr1[j][i];			
				for (int l = 0; l < k; l++) {
					arr3[j][l] += r * arr2[i][l];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(arr3[i][j] + " ");
			}
			System.out.println();
		}
	}
}
