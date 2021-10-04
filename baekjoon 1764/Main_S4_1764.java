package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S4_1764 {
	static int n;
	static int m;
	static int count;
	static HashSet<String> NoneListen;
	static ArrayList<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 듣도 못한 사람을 저장하기 위한 해쉬셋
		NoneListen = new HashSet<>();
		// 듣도 보도 못한 사람을 담을 리스트
		list = new ArrayList<String>();
		
		// 듣도 못한 사람을 해쉬셋에 저장하기
		for (int i = 0; i < n; i++) {
			NoneListen.add(br.readLine());
		}
		
		// 보도 못한 사람을 따로 처리하지 않고
		// 입력을 받아서 해당하는 것이 있으면 리스트에 추가해주고 카운트 증가
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (NoneListen.contains(str)) {
				list.add(str);
				count++;
			}
		}
		
		// 리스트를 정렬하기
		Collections.sort(list);
		
		// 듣보잡의 개수 출력
		System.out.println(count);
		
		// 리스트의 내용을 출력하기
		for (String s : list) {
			System.out.println(s);
		}
	}

}
