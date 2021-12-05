package BOJ_silver;

import java.util.*;
import java.io.*;

public class Main_S4_6219 {
	static int a;
	static int b;
	static int d; // 포함해야 하는 수
	static int max = 4000001;
	static boolean prime[] = new boolean[max];
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 에라토스테네스의 체를 사용해서 소수 배열 구성
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		
		for (int i = 2; i * i < max; i++) {
			if (prime[i]) {
				for (int j = i * i; j < max; j += i) {
					prime[j] = false;
				}
			}
		}
		
		// 입력받기
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		// a~b사이 탐색
		for (int i = a; i <= b; i ++) {
			if (prime[i]) { // 소수라면
				if (check(i)) // 체크 함수의 return이 트루라면
					cnt++; // cnt 증가
			}
		}
		
		System.out.println(cnt);
	}
	
	// d가 포함되는 지 확이하는 함수
	static boolean check(int n) {
		while (n > 0) { // n을 계속 나눌것이기 때문에 n이 0보다 클 때까지 반복한다.
			int num = n % 10; // 1의 자리에 해당하는 한 자리의 숫자
			n /= 10; // 10으로 나눈다.
			
			if (num == d) // 만약 나머지가 d와 같다면 d를 포함하는 것이기 때문에 return true
				return true;
		}
		// while을 다 돌았는데 return되지 않았다면 포함하지 않는 것이니까 return false
		return false;
	}
}