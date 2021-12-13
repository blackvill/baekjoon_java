package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G1_1016 {
	static long min;
	static long max;
	static int sqrt;
	static boolean[] check;
	static long[] num;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		min = Long.valueOf(st.nextToken());
		max = Long.valueOf(st.nextToken());
		
		int result = (int) (max - min + 1);
		sqrt = ((int) Math.sqrt(max));
		
		check = new boolean[result];
		num = new long[result];
		 
		
		for(long i = 2; i <= sqrt; i++) { 
				long squared = i * i;
				long start = min % squared == 0 ? min / squared : (min / squared) + 1;
				
				for(long j = start; j * squared <= max; j++) {
					check[(int) ( (j * squared) - min)] = true;
				}
		}
		
		for(int i = 0; i < result; i++) {
			if(!check[i])
				cnt++;
		}
		
		System.out.println(cnt);
	}
}