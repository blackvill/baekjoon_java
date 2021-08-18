package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_11399 {
	static int n;
	static int[] time;
	static int timesum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		time = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 시간 입력받기
		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순으로 정렬 - 앞에 사용하는 사람의 시간이 적을수록 총 대기 시간이 줄어든다.
		Arrays.sort(time);
		
		for (int i = 0; i < n; i++) { // 사용자들의 시간을 더해야한다.
			for (int j = 0; j <= i; j++) { // 사용자가 이전의 사용자의 시간을 추가로 기다려야한다.
				timesum += time[j];
			}
		}
		System.out.println(timesum);
	}

}
