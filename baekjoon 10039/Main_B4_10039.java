package BOJ_bronze;

import java.io.*;

public class Main_B4_10039 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine());
			
			n = n >= 40 ? n : 40; // 40점이 안되면 40점, 40점 이상이면 원 점수
			sum += n; // 합
		}
		
		// 평균 출력
		System.out.println(sum / 5);
	}
}