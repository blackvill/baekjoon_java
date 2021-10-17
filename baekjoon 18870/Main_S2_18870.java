package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S2_18870 {
	static int n;
	static int[] arr;
	static int[] copy;
	static HashMap<Integer, Integer> map;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		copy = new int[n]; // arr을 정렬해야하기 때문에 최종 출력할 때를 위해 복사 
		
		map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// copy와 arr에 값 입력
		for (int i = 0; i < n; i++) {
			copy[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 정렬
		Arrays.sort(arr);
		
		// 해쉬맵에 arr[i] 값을 순서대로 넣는다.
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) // 이미 값이 들어있는 거라면
				map.put(arr[i], cnt++); // 그 다음 값으로 넣는다
		}
		
		// 입력된 값에 해당하는 cnt 값을 출력한다.
		for (int i = 0; i < n; i++) {
			sb.append(map.get(copy[i])).append(" ");
		}
		
		System.out.println(sb);
	}
}