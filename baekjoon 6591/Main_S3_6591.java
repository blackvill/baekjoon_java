package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_6591_김재욱 {
	static long n;
	static long k;
	static long result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        while (true) {
        	// 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            k = Long.parseLong(st.nextToken());
            result = 1;
            
            // 0 0 입력 시 종료
            if (n == 0 && k == 0)
            	break;

            // 약분이 되면 약분하기
            if (k > n - k)
            	k = n - k;
            
            for (long i = 1; i <= k; i++) {
                result *= n--;
                result /= i;
            }
            
            System.out.println(result);
        }
    }
}