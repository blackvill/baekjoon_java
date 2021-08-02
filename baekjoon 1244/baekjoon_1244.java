package BOJ;

import java.util.Scanner;

public class Baekjoon_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 몇칸짜리 
		int[] arr = new int[n]; // 배열 만들기
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt(); // 배열 채우기
		int student_count = sc.nextInt(); //학생 수
		for (int i = 0; i < student_count; i++) {
			int sex = sc.nextInt(); // 성별
			int switch_num = sc.nextInt(); // 스위치 번호
			if(sex == 1) { // 남자
				for(int j = 0; j < n; j++) //뽑은 수의 배수 위치에 있는 스위치의 상태
					if((j + 1) % switch_num == 0) // 배수인지 체크 (switch_num을 -1 안하고 j+1을 한 이유 : j는 0 부터 시작)
						arr[j] = arr[j] == 1 ? 0 : 1;
			}
			else if (sex == 2){ // 여자
				arr[switch_num - 1] = arr[switch_num - 1] == 1 ? 0 : 1; // 입력받은 수 확인 해서 토글
				for(int j = 1; j < n / 2; j++) { // + 방향과 - 방향 둘다 확인을 하기때문에 많아도 n의 반까지만 확인
					if(switch_num - 1 + j >= n || switch_num - 1 - j < 0) // 범위 검사해서 벗어나면 탈출
						break;
					if(arr[switch_num - 1 - j] == arr[switch_num - 1 + j]) { // -방향과 +방향의 값이 같으면
						arr[switch_num - 1 - j] = arr[switch_num - 1 - j] == 0 ? 1 : 0; // 토글
						arr[switch_num - 1 + j] = arr[switch_num - 1 + j] == 0 ? 1 : 0; // 토글
					}
					else
						break;
				}
			}
		}
		for (int i = 0; i < n; i++) { // 배열
			System.out.print(arr[i] + " "); // 결과 출력
			if ((i + 1) % 20 == 0) // 한줄에 20칸씩 출력이니까 20으로 나눠서 나머지가 0이면
				System.out.println(); // 다음줄로 개행
		}
	}
}