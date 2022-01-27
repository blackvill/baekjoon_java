package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1120_김재욱 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int result = a.length(); // a의 길이만큼 다 다른 경우가 가장 많은 차이가 나는 경우이므로
        // a의 길이로 초기화

        // b와 a와의 차이의 개수를 구하는 것
        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int tmp = 0; // 다른 문자의 개수를 세기 위한 임의의 변수

            // 서로의 차이를 구하기 위한 반복문
            for (int j = 0; j < a.length(); j++) {
            	// a의 j부터 b의 문자열과 비교해서 체크
                if (a.charAt(j) != b.charAt(j + i)) {
                    tmp++; // 다를때마다 카운트 증가
                }
            }
            
            result = Math.min(result, tmp);
        }

        System.out.println(result);
    }
}