package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S1_1946 {
	static int T;
	static int n;
	static int[][] person;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			person = new int[n][2];	// 각 지원자의 서류, 면접 성적
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				person[i][0] = Integer.parseInt(st.nextToken());	
				person[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 서류심사 성적을 기준으로 정렬한다.
			Arrays.sort(person, new Comparator<int[]>() {
				@Override
				public int compare(int[] arr1, int[] arr2) {
					return Integer.compare(arr1[0], arr2[0]);
				}
			});
			
			// 서류심사 1등은 무조건 뽑기 때문에 1
			count = 1;
			
			// 서류 심사 1등을 기준으로 잡는다.
			int base = person[0][1];
			
			for(int i = 1; i < n; i++) {
				// 현재 기준인 사람보다 면접 순위가 높다면 뽑는다.
				if(person[i][1] < base) {
					base = person[i][1]; // 뽑은 사람을 기준으로 변경
					count ++;
				}
			}
			System.out.println(count);
		}
	}
}