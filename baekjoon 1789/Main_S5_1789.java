package BOJ;

import java.util.Scanner;

public class Main_S5_1789 {
	static long s; // 자연수의 합
	static long n; // 사용한 자연수의 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.nextLong();

		long i = 1; // s의 합은 1부터 최대한 더하는게 가장 많은 숫자를 사용하게 된다.
		while (true) {
			s -= i;
			n++; // n을 증가
			if (s < 0) // 다음 수보다 빠진 s가 작거나 같아지면 똑같은 수를 사용해야하므로 조건 성립 안함
				break; // n을 위에서 증가시켰는데 감소를 시키지 않는 이유는 남은 숫자가 이후에 결국 추가되기 때문
			i++;
		}
		System.out.println(n - 1);
	}

}
