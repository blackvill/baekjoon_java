package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S5_9237 {
	static int n;
	static int[] arr;
	static int result;
	static int day;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		day = 2;
		
		for (int i = n - 1; i >= 0; i--) {
			result = Math.max(arr[i] + day, result);
			day++;
		}
		
		System.out.println(result);
	}

}
