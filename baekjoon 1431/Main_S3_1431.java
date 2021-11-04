package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S3_1431 {
	static int n;
	static String[] serial;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		serial = new String[n];
		
		// 시리얼 번호 입력받기
		for (int i = 0; i < n; i++) {
			serial[i] = br.readLine();
		}
		
		Arrays.sort(serial, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) // 길이가 짧은 것을 오름차순 정렬
					return -1;
				else if (o1.length() == o2.length()) {
					if (sum(o1) == sum(o2)) { // 합이 같은 경우
						return o1.compareTo(o2); // 둘을 비교해서 사전순으로 정렬
					}
					else { // 합이 다른 경우
						return Integer.compare(sum(o1), sum(o2)); // 오름차순 정렬
					}
				}
				else
					return 1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(serial[i]);
		}
	}
	
	// 시리얼 번호에서 숫자로 이루어진 경우 해당 값들의 합을 구하는 방식
	public static int sum(String str) {
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
				sum += str.charAt(i) - '0';
		}
		
		return sum;
	}
}
