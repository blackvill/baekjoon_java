package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1026 {
	static int s;
	static int[] a;
	static int[] b;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		a = new int[n];
		b = new int[n];
		
		// a 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		// b 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		// a와 b 정렬
		Arrays.sort(a);
		Arrays.sort(b);
		
		// a는 오름차순으로, b는 내림차순으로 곱해줌
		for (int i = 0; i < n; i++) {
			s += a[i] * b[n - 1 - i];
		}
		
		// 결과를 출력
		System.out.println(s);
	}
}