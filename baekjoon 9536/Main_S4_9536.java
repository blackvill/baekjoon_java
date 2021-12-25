package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_S4_9536 {
	static int n;
	static String str;
	static HashMap<String, String> animal = new HashMap();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			str = br.readLine(); // 동물들의 섞인 울음소리
			String[] sounds = str.split(" "); // 울음소리들을 잘라서 배열에 담기
			
			while(true) {
				String word = br.readLine(); // 각 동물의 울음소리 담기
				String[] wordTokens = word.split(" "); // 어떤 동물의 울음소리인지 알기 위해 자르기
				
				// 만약 2번째 단어가 goes가 아니라면 (그럼 울음소리를 받는것이 아니므로 종료)
				if(!wordTokens[1].equals("goes")) {
					break;
				}else { // 동물, 울음소리로 해시맵에 저장
					animal.put(wordTokens[0], wordTokens[2]);
				}
			}
			
			// 사운드들의 길이만큼
			for(int j = 0; j < sounds.length; j++) {
				// 만약 맵에 저장되어 있는 소리가 아니라면
				if(!animal.containsValue(sounds[j])) {
					// 해당 소리를 출력
					System.out.print(sounds[j] + " ");
				}
			}
			System.out.println();
		}
	}
}