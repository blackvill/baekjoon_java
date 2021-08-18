package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S2_11047 {
	static int n; // 동전의 수
	static int k; // 동전의 가치 합
	static Integer[] money;
	static int count; // 동전의 개수
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		money = new Integer[n];
		
		// n개의 동전들 입력받기
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		// 내림차순으로 정렬
		Arrays.sort(money, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			};
		});
		// 동전을 이용해서 만들수 있을때 까지 반복
		int c = 0;
		while (true) {
			if (k == 0) break;
			
			if (k >= money[c]) { // k를 money[c]로 채울수 있음
				count += (k / money[c]); // money[c]를 사용한 수만큼 count 증가
				k %= money[c]; // money[c]를 사용 후 남은 k 
			}
			c++; // 다음 동전으로 변경
		}
		System.out.println(count);
	}
}