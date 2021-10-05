package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S3_1269 {
	static int a;
	static int b;
	static HashSet<Integer> aSet;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		aSet = new HashSet<>();
		
		// a 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			aSet.add(Integer.parseInt(st.nextToken()));
		}
		
		// b 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (aSet.contains(num)) // 만약 있는 값이라면
				aSet.remove(num); // 해당 값을 제거해주고
			else // 없다면
				aSet.add(num); // 해당 값을 추가해준다.
		}
		
		// 해쉬셋의 크기 출력
		System.out.println(aSet.size());
	}
}