package BOJ_bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_B5_13277 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		System.out.println(a.multiply(b));
	}

}
