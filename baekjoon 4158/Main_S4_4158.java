package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S4_4158 {
	static int n;
	static int m;
	static HashSet<Integer> set;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// 0, 0 이 들어오면 종료
			if (n == 0 && m == 0) {
				break;
			}
			
			// 초기화
			set = new HashSet<>();
			count = 0;
			
			// 상근이가 가진 cd를 셋에 담기
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(br.readLine()));
			}
			
			// 선영이가 가진 cd가 셋에 있는지 확인
			for (int j = 0; j < n; j++) {
				int cd = Integer.parseInt(br.readLine());
				
				// 이미 있다면
				if (set.contains(cd))
					count++; // 공통으로 가지고 있는 것이니까 count 증가
			}
			
			System.out.println(count);
		}
	}
}
