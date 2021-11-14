package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S3_2012 {
	static int n; // 사람 수 
	static int arr[]; // 생각하는 등수 배열
	static long result; // 결과 (혹시몰라서 long형으로 잡아줌)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람 수
		n = Integer.parseInt(br.readLine());
		// 초기화
		arr = new int[n];
		
		// 각자 생각하는 등수 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 오름차순으로 정렬하기
		Arrays.sort(arr);
		
		// |각자 생각한 등수 - 실제 등수|의 합 구하기
		for (int i = 0; i < n; i++) {
			result += Math.abs(arr[i] - (i + 1));
		}
		
		// 결과 출력
		System.out.println(result);
	}
}