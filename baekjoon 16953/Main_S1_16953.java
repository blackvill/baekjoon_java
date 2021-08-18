package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16953 {
	static int a;
	static int b;
	static int count = 1; // 총 연산 횟수, 문제 요구가 최소횟수 + 1이기 때문에 시작을 1로 함
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		while (b != a) {
			if (b < a) {// a보다 작아지면 b로는 구현이 되지 않는것
				// b가 이로 나누어지지 않으면 구현되지 않는것
				count = -1;
				break;
			}
			
			if (b % 10 == 1) {// 마지막 자릿수가 1이면 (a에서 할수 있는 연산은 2를 곱하거나 맨 마지막에 1을 추가하는거)
				b /= 10; // 맨뒤의 1을 제거
			}
			else if (b % 2 == 0){
				b /= 2; // 아니면 b를 2로 나눠준다.
			}
			else {
				count = -1;
				break;
			}
			count++;
		}
		System.out.println(count);
	}

}
