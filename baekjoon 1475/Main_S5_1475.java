package BOJ_silver;

import java.io.*;

public class Main_S5_1475 {
	static int n;
	static int arr[];
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[9];
		
		// 각 자리수로 나눠서
		// 어떤 숫자를 사용해야하는지 구하기
		while (n > 0) {
			int i = n % 10;
			
			if (i != 9)
				arr[i]++;
			else
				arr[6]++;
			
			n /= 10;
		}
		
		// 6과 9를 사용할 수 있으니까 반으로 처리하는데
		// 나머지가 있으면 1증가 아니면 0증가
		arr[6] = arr[6] % 2 == 0 ? arr[6] / 2 : (arr[6] + 1) / 2;  
		
		// 최대 갯수를 구하기
		for (int i = 0; i < 9; i++) {
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(max);
	}
}