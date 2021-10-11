package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1074 {
	static int N;
	static int r;
	static int c;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()); //행
		c = Integer.parseInt(st.nextToken()); //열
		
		int size = (int) Math.pow(2, N); //한 변의 사이즈
		
		devide(size, r, c);
		System.out.println(count);
	}

	private static void devide(int size, int r, int c) {
		if(size == 1)
			return;
		
		if(r < size/2 && c < size/2) {
			devide(size/2, r, c);
		}
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4;
			
			devide(size/2, r, c - size/2);
		}
		else if(r >= size/2 && c < size/2) {
			count += (size * size / 4) * 2;
			
			devide(size/2, r - size/2, c);
		}
		else {
			count += (size * size / 4) * 3;
			
			devide(size/2, r - size/2, c - size/2);
		}
	}
}
