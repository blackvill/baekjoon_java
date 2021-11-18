package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main_S3_20291 {
	static int n;
	static Map<String, Integer> map = new TreeMap<String, Integer>();
	// 자동으로 정렬을 해주기 때문에 treemap을 사용

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String name = br.readLine(); // 파일명을 다 입력받기
			// 입력받은 파일 명을 substring을 이용해 .이후부터 잘라내기
			String extension = name.substring(name.indexOf(".") + 1);
			
			// 이미 map에 있다면 해당 값을 1 증가 시키고
			if (map.containsKey(extension))
				map.put(extension, map.get(extension) + 1);
			else // 없다면 해당 값을 1로 넣어주기
				map.put(extension, 1);
		}
		
		// 결과 출력
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}
}