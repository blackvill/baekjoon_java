package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_1758_김재욱 {
	static int n; // 사람 수
	static int arr[]; // 사람들이 주는 팁을 담을 배열
	static int turn = 1; // 현재 몇번째로 받는지를 담는 변수
	static long totaltip; // 받을수 있는 팁들의 합

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람 수 입력받기
		n = Integer.parseInt(br.readLine());
		
		// 초기화
		arr = new int[n];
		
		// 팁들을 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 팁들을 정렬하기 >> 이렇게 하면 오름차순 정렬이 되는데 역순으로 사용하면 되므로 따로 정렬을 재정의 하지 않았다.
		Arrays.sort(arr);
		
		// 역순으로 반복
		for (int i = arr.length - 1; i >= 0; i--) {
			// 팁 : 줄려고 한 돈 - (자신의 차례 - 1)
			int tip = arr[i] - (turn - 1);
			// 만약에 팁이 0보다 크다면 (음수가 아니라면)
			if (tip >= 0)
				totaltip += tip; // 더하기
			turn++; // 턴은 계속 증가
		}
		
		// 총 받을 수 있는 팁을 출력하기
		System.out.println(totaltip);
	}
}