package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main_S4_1822_김재욱 {
	static int a; // a의 개수
	static int b; // b의 개수
	static TreeSet<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		set = new TreeSet<>();
		
		// A에 포함이 되어있다면 추가
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		// B에 포함이 되어있다면 제거
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (set.contains(n))
				set.remove(n);
		}
		
		// 차집합의 크기
		System.out.println(set.size());
		// 차집합의 내용
		for(int n : set)
            System.out.print(n + " ");
	}
}