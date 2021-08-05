package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493_김재욱 {
	/*
	 * KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다.
	 * 실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고,
	 * 각 탑의 꼭대기에 레이저 송신기를 설치하였다.
	 * 모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사하고,
	 * 탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다.
	 * 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다. 
	 * 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고,
	 * 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자.
	 * 그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고,
	 * 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이,
	 * 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다.
	 * 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.
	 * 탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 
	 * 알아내는 프로그램을 작성하라.
	 * 
	 *  첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하이다.
	 *  둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어진다.
	 *  탑들의 높이는 1 이상 100,000,000 이하의 정수이다.
	 */

	static int n;
	static int num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner를 사용해서 해보았는데 이 경우, 메모리 에러가 발생한다.
		// stack을 쓰는 경우는 그냥 맘 편하게 버퍼드리더를 쓰자!! 

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>(); // 인덱스를 담는 스택
		
		n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 토큰나이저로 단어를 쪼개준다.
		
		// 처음은 무조건 0이니까 따로 처리해줌
		num = Integer.parseInt(st.nextToken());
		stack.push(num);
		index.push(1);
		System.out.print("0 ");
		
		for (int i = 2; i <= n; i++) {
			num = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) { //빌때까지 반복
				if (num < stack.peek()) { // 스택의 top값이 num 보다 크면
					System.out.print(index.peek() + " "); // 인덱스의 top을 출력
					break;
				}
				stack.pop(); // 빼기
				index.pop(); // 빼기
			}
			if (stack.isEmpty()) { // 스택이 비어있으면
				System.out.print("0 ");
			}
			stack.push(num); // 값넣기
			index.push(i); // 인덱스 갱신
		}
	}
}
