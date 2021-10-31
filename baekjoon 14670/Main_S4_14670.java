package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_14670 {
	static int n; // 약의 종류의 개수
	static int r; // 증상의 개수
	static HashMap<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 효능
			int stat = Integer.parseInt(st.nextToken());
			// 이름
			int name = Integer.parseInt(st.nextToken());
			
			map.put(stat, name); // 맵에 등록
		}
		
		r = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < r; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < count; j++) {
				int dis = Integer.parseInt(st.nextToken());
				
				if (map.containsKey(dis)) { // 증상에 맞는 약이 있다면
					sb.append(map.get(dis)).append(" "); // 약 번호를 등록
				}
				else { // 없다면
					sb.setLength(0); // StringBuilder를 비우고 
					sb.append("YOU DIED"); // 넣어준다.
					break; //탈출
				}
			}
			System.out.println(sb); // 저장된 것을 비워준다.
			sb.setLength(0); // 스트링 빌더를 놔두면 중복 출력이 되기 때문에 여기서 비워준다.
		}
	}
}
