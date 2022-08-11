package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_11650 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];

		// 값 입력받기
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (e1, e2) -> {
			// 같으면 y축 기준 정렬
			if(e1[0] == e2[0])
				return e1[1] - e2[1];
			else
				return e1[0] - e2[0];
		});

		for(int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}