package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_S5_10867_김재욱 {
	static int n;
	static TreeSet<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		set = new TreeSet<>();
		
		// 입력을 받아서
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			set.add(num); // 셋에 추가해주기
		}
		
		Iterator iter = set.iterator();
		
		// 다음 값이 있다면 출력
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
