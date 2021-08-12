package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_1992 {
	static int n; //영상의 크기 , 2제곱수
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		// 배열 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = str.charAt(j) - '0'; // 문자를 숫자로 입력
		}
		devide(0, 0, n);
	}
	
	public static void devide(int a, int b, int n) { // 시작 x,y 좌표와 배열의 크기
		if (check(a, b, n) == 1) { // 리턴값이 참이면
			System.out.print(map[a][b]); // 시작 좌표의 값을 출력
		}
		else { //참이 아니면 중간에 다른것이 있다는 소리
			System.out.print("(");
			int N = n / 2; // 탐색 범위를 반으로 줄임
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					devide(a + N * i, b + N * j, N);
					// 기존의 a,b 좌표를 기준으로 쪼개진 영역을 다 탐색해야하므로
					// 시작 좌표 + 쪼개진 부분의 크기
				}
			}
			System.out.print(")");
		}
	}
	
	public static int check(int i, int j, int n) { // 시작 x,y좌표와 배열의 크기
		int start = map[i][j]; // start에 시작값 넣어주고
		for (int a = i; a < i + n; a++) {
			for (int b = j; b < j + n; b++) {
				if (map[a][b] != start) {// map을 탐색하면서 시작값과 다르면
					return 0; // 거짓
				}
			}
		}
		return 1; // 참
	}
}
