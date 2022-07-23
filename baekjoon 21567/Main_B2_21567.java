package BOJ_bronze;

import java.io.*;
import java.math.*;

public class Main_B2_21567 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int[] number = new int[10];
		// 1로 선언해주기 (값이 너무 커질 수 있기 때문에 BigInteger로 처리)
		BigInteger num = new BigInteger("1");
		
		// 입력값 3개 곱하기
		for (int i = 0; i < 3; i++)
			num = num.multiply(new BigInteger(br.readLine()));
		
		// 0이 아닐 때까지 반복
		while(num.compareTo(BigInteger.ZERO) != 0) {
			// 10으로 나눈 나머지값의 배열 값 수 증가
			number[num.remainder(BigInteger.TEN).intValue()]++;
			// 10으로 나누기
			num = num.divide(BigInteger.TEN);
		}
		
		for(int n : number) {
			System.out.println(n);
		}
	}
}