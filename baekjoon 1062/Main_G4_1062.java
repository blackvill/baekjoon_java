package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1062 {
	static int n;
	static int k;
	static boolean[] visited = new boolean[26]; // 사용된 알파벳을 담을 배열
	static String[] str_arr;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//입력 받기
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		str_arr = new String[n];
		
		if (k < 5) {
			System.out.println("0");
			return;
			// 5개는 무조건 들어가야함
		}
		else if (k == 26) {
			System.out.println(n);
			return;
			// 26개라면 무조건 모든 단어 완성 가능
		}
		else { // 이 단어들은 무조건 사용되므로 visited를 true로 바꿔준다.
			for (int i = 0; i < n; i++) {
				String str = br.readLine(); 
				str_arr[i] = str.substring(4, str.length() - 4); // 시작 4개, 끝 4개 제거해서 넣어주기
				// 하지만 무조건 나오는 단어를 제거해주는 것이 탐색의 양을 줄여줄 수 있으므로 성능이 좋아짐
//				str_arr[i] = br.readLine(); // 그냥 입력 받아도 괜찮
			}
			
			visited['a' - 97] = true;
			visited['n' - 97] = true;
			visited['t' - 97] = true;
			visited['i' - 97] = true;
			visited['c' - 97] = true;
			
			comb(0, 0);
			System.out.println(max);
		}
	}
	
	public static void comb (int cnt, int start) {
		int count= 0;
		if (cnt == k - 5){ // cnt는 조합문 내에서 사용한 단어의 개수이므로 k-5개로 비교를 한다.
			for (int i = 0; i < n; i++) {
				boolean Can = true; // 사용할수 있는 단어를 우선 true로 초기화
				for (int j = 0; j < str_arr[i].length(); j++) {
					if (!visited[str_arr[i].charAt(j) - 97]) {
						// 만약 visited에 해당 단어가 없다면
						Can = false; // 이것은 사용할 수 없는 단어
						break;
					}
				}
				if (Can) // 사용할 수 있으면
					count++; // count 증가
			}
			max = Math.max(max, count); // count와 max의 값을 비교해서 더 큰것을 max
			return;
		}
		
		for (int i = start; i < 26; i++) {// 알파벳 수
			if (visited[i] == true)
				continue;
			visited[i] = true; // 사용한것으로 변겅
			comb(cnt + 1, i + 1); // 다음 조합
			visited[i] = false; // 사용했으니까 비사용으로 바꿔줌
		}
	}
}
