package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_S5_13706 {
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		// 범위가 크기때문에 BigInteger를 사용
        BigInteger n = new BigInteger(br.readLine());
        BigInteger start = new BigInteger("1");
        BigInteger end = n;
        BigInteger mid;
 
        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));
 
            // mid * mid와  n 비교
            // 같다면 0
            // mid * mid가 크다면 1
            // mid * mid가 작다면 -1
            result = (mid.multiply(mid)).compareTo(n);
            
            // 같다면 종료
            if (result == 0)
            	break;
            // mid * mid가 크다면
            else if (result == 1)
            	// 1을 빼고 연산
            	end = mid.subtract(new BigInteger("1"));
            // mid * mid가 작다면
            else
            	// 1을 더하고 연산
            	start = mid.add(new BigInteger("1"));
        }
        
        System.out.println(mid);
    }
}