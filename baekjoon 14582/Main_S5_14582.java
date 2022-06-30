package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_14582 {
	static int[] arr1;
	static int[] arr2;
	static boolean win;
	static int sum1, sum2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr1 = new int[9];
		arr2 = new int[9];
		
		// 1번팀
		for (int i = 0; i < 9; i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 2번팀
		for (int i = 0; i < 9; i++)
			arr2[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 9; i++) {
			sum1 += arr1[i];
			// 초에 이기고 있는 경우
			if (sum1 > sum2)
				win = true;
			
			sum2 += arr2[i];
			// 말에 이기고 있는 경우
			if (sum1 > sum2)
				win = true;
		}
		// 역전패일 경우
		if (sum1 < sum2 && win)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}