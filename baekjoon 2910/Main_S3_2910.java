package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S3_2910 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		// 입력으로 들어와서 일단 만들었지만 안쓰이는 변수
		// 모든 값이 c보다 작다는거만 알면 됨
		int c = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine());
		//해쉬맵을 이용
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 이미 맵에 값이 존재하면 value를 1증가, 아니라면 1로 넣기
			if (map.containsKey(num)) {
				map.replace(num, map.get(num) + 1);
			}
			else {
				map.put(num, 1);
			}
		}
		
		// 맵의 key들을 모두 리스트에 저장한다.
		ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());

		// 리스트에 있는 값들을 정렬
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(map.get(b), map.get(a));
			}
		});
		
		// Iterator를 통해서 출력
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer tmp = it.next();
			for (int i = 0; i < map.get(tmp); i++) {
				System.out.print(tmp + " ");    
			}

		}
	}
}
