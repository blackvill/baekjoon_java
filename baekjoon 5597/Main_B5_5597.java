package BOJ_bronze;

import java.io.*;

public class Main_B5_5597 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[31];
		
		for(int i = 1; i < 29; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n] = 1;
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != 1)
				System.out.println(i);
		}
	}
}