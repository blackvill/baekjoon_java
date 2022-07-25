package BOJ_silver;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_S4_2870 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		// 숫자만 거르기 위한 패턴
		Pattern p = Pattern.compile("[\\d]+");
		
		for (int i = 0; i < n; i++) {
			// 입력받은 문자열 패턴에 걸리는 것 찾기
			String str = br.readLine();
			Matcher m = p.matcher(str);
			
			// 찾은 값이 있으면
			while (m.find()) {
				// 0으로 시작하면 0 없애기
				String num = m.group().replaceAll("^0+", "");
				// 리스트에 넣으면서 문자열의 길이가 0이면
				// 위에서 0으로 시작해서 지워진것이므로 0으로 넣고
				// 아닌 경우라면 숫자 값 넣기
				list.add(num.length() == 0 ? "0" : num);
			}
		}
		
		// 리스트 정렬하기
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 길이가 같으면 값 비교해서 작은 게 앞
				// 길이가 다르면 길이가 짧은 게 앞
				return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
			}
		});
		
		// 정렬된 리스트에 있는 값들 출력
		for (String n : list)
			System.out.println(n);
	}
}