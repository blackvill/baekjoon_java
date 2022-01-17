package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1138 {
	static int n;
	static int[] arr;
	static int first;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		first = Integer.parseInt(st.nextToken());
		
		arr[first] = 1; // 1이 들어갈 위치 고정
		
		for (int i = 1; i < n; i++) {
			// 1이후의 숫자들이 왼쪽에 몇개가 있는지에 대한 값을 입력받기
			int num = Integer.parseInt(st.nextToken());
			// 위치를 확인하기 위한 변수
			int check = 0;
			
			// 배열의 처음부터 탐색			
			for (int j = 0; j < n; j++) {
				// 만약 arr[j]가 0이라면 check를 증가
				// check는 해당 숫자의 왼쪽에 있는 0으로 비어있는 칸의 개수
				if (arr[j] == 0) { 
					check++;
				}
				// check가 입력받은 숫자 + 1
				// 작은 숫자부터 들어가기 때문에
				// 왼쪽에 빈칸이 num의 갯수와 같다면
				// 그 다음으로 오는 빈칸에 현재 숫자를 넣으면 된다.
				if (check == num + 1) {
					arr[j] = i + 1; // i+1인 이유는 2부터가 아닌 1부터 반복문을 시작했기 때문
					break;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}