package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1806 {
	static int n;
	static int s; // 요구합
	static int number[]; // 수열을 담을 배열
	static int sum; // 합
	static int result = 100001; // 최대로 들어왔을 때의 개수가 100000이니까 그거보다 큰 값으로 초기 설정
	static int left = 0; // 왼쪽 포인터
	static int right = 0; // 오른쪽 포인터

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		number = new int[n];
		
		// 수열 값 입력받기
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken()); // 수열 값 저장
		}
		
		while (true) {
			if (sum >= s) { // 합이 요구값이상이면
				sum -= number[left]; // 왼쪽에서 한칸 이동을 시키니까 합에서 감소
                result = Math.min(result, (right - left));
                // 현재의 길이와 지금까지의 최소 길이를 비교해서 최소값으로 갱신
                left++; // 왼쪽을 오른쪽으로 이동
			}
			else if (right == n) { // right가 n이다? 끝까지 탐색이 끝났다.
				break; // 탈출
			}
			else // 합이 요구값이상도 아니고, 끝도 아니라면
				sum += number[right++]; // 오른쪽을 증가
		}
		
		// 만약 결과가 처음 입력값과 같다면
		if (result == 100001) {
			System.out.println("0"); // 불가능한 것이니까 0출력
		}
		else // 아니면
			System.out.println(result); // 결과 출력
	}
}