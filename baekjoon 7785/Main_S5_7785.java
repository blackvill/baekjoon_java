package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S5_7785 {
	static int n;
	static HashSet<String> log;
	static ArrayList<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		log = new HashSet<>();
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken(); // 이름
			String status = st.nextToken(); // enter or leave의 상태
			
			// 만약 enter라면 해쉬셋에 저장
			if (status.compareTo("enter") == 0) {
				log.add(name);
			}
			else {
				if (log.contains(name)) // 있는지 체크하고
					log.remove(name); // 있다면 제거
			}
		}
		// 리스트에 해쉬 내용을 담아준다.
		list = new ArrayList(log);
		// 정렬 시키기
		Collections.sort(list);
		
		// 사전 역순으로 출력
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
	}
}