package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2477 {
	static int n; // 1m^2당 참외수
	static int x; // x
	static int y; // y
	static int x_low; // 제거된 x
	static int y_low; // 제거된 y
	static int[] length = new int[6];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dest = Integer.parseInt(st.nextToken()); // 방향
			length[i] = Integer.parseInt(st.nextToken()); // 길이
		}
		// 가장 긴 변을 찾는것
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (x < length[i]) {
					x = length[i];
				}
			}
			else {
				if (y < length[i]) {
					y = length[i];
				}
			}
		}
		// 파인 지점을 찾는 것
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (y == length[(i + 5) % 6] + length[(i + 1) % 6]) {
					x_low = length[i];
				}
			}
			else {
				if (x == length[(i + 5) % 6] + length[(i + 1) % 6]) {
					y_low = length[i];
				}
			}
		}
		// 가장 긴(가로 * 세로)- 가장 짧은 (가로 * 세로)
		// 큰 사각형 면적 - 잘려있는 사각형 면적 = ㄱ자 면적
		int result = (x * y) - (x_low * y_low);
		result *= n; // 면적 * 면적당 참외수
		System.out.println(result);
	}

}
