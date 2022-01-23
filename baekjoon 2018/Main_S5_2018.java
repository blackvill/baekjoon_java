package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_2018_김재욱 {
	static int n;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cnt = 1; // 자기 자신일 때 포함

		for(int i = 1; i < (n / 2) + 1; i++) { // 반을 넘어가면 연속 수로 n을 구할 수 없음
			int sum = i;
			
			for(int j = i + 1; j < n; j++) {
				sum += j;
				
				if(sum == n) { // n과 같으면 cnt 증가
					cnt++;
					break;
				}
				if(sum > n) { // n보다 커지면 탈출
					break;
				} 
			}
		}
		System.out.println(cnt);
	}
}