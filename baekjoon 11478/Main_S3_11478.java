package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_S3_11478 {
	static String str; // 입력받을 문자열
	static HashSet<String> set; // 입력받은 문자열을 잘라서 담을 셋

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		set = new HashSet<>();
		
		for (int i = 0; i <= str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				// substring을 사용해서 문자열을 잘라준다.
				String s = str.substring(i, j);
				
				// if를 통해서 포함이 되어있는지 체크할려고 하였으나
				// set은 알아서 중복처리를 해준다.
				// 따라서 불필요한 연산이 추가 되므로 없이 사용한다.
				// 중복처리 x : 메모리 564676KB / 시간 960ms
				// 중복처리 o : 메모리 567776KB / 시간 1108ms
				//if (!set.contains(s)) {
					set.add(s);
				//}
			}
		}
		
		// set의 사이즈 출력 == 다른 문자열의 개수 출력
		System.out.println(set.size());
	}
}