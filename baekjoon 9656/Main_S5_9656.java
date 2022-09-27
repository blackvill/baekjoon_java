package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_9656 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		// 1개, 3개를 가져갈 수 있으므로
		// 짝수개면 무조건 SK가 이기고 홀수라면 CY가 이긴다.
		if (n % 2 == 0)
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}