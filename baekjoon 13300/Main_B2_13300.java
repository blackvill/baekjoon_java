package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13300 {
	static int n; // 학생의 수
	static int k; // 방 당 인원 배정 수
	static int[] female = new int[6]; // 여자
	static int[] male = new int[6]; // 남자
	static int room; // 방 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken()) - 1;
			
			if (sex == 0) {
				female[grade]++;
			}
			else if (sex == 1) {
				male[grade]++;
			}
		}
		for (int i = 0; i < 6; i++) {
			if (female[i] != 0) {
				room += (female[i] / k);
				if (female[i] % k != 0)
					room += 1;
			}
			if (male[i] != 0) {
				room += (male[i] / k);
				if (male[i] % k != 0)
					room += 1;
			}
		}
		System.out.println(room);
	}

}
