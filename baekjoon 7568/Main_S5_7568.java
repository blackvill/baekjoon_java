package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_7568 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][2];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());	// 몸무게 
			arr[i][1] = Integer.parseInt(st.nextToken());	// 키 
		}

		for(int i = 0; i < n; i++) {
			int rank = 1;

			for(int j = 0; j < n; j++) {
				if(i == j)
					continue;
				// 키가 작던지, 덩치가 작으면 그 등수를 증가시킨다
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}

			// 드수 출력
			System.out.print(rank + " ");
		}
	}
}