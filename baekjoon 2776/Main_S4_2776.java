package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S4_2776_김재욱 {
	static int T;
	static int n;
	static int m;
	
	static HashSet<Integer> note;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder(); // 스트링빌더를 사용하지 않으니까 시간초과 발생
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// note1을 나타내는 해쉬셋
			note = new HashSet<>();
			
			// 해쉬셋에 값 입력해주기
			for (int i = 0; i < n; i++) {
				note.add(Integer.parseInt(st.nextToken()));
			}
			
			m = Integer.parseInt(br.readLine());
			
			// 노트에 있다면 1 출력, 없다면 0 출력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m ; i++) {
				if (note.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1").append("\n");
				}
				else
					sb.append("0").append("\n");
			}
			System.out.println(sb);
		}
	}
}