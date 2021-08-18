package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_1449 {
	static int n;
	static int l;
	static int[] position;
	static int count = 1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken()) - 1; // 구멍에서부터 양쪽으로 0.5cm씩 빠지면 총 1cm가 빠짐
		position = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			position[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(position); // 오름차순으로 정렬
		int start = position[0]; 
		for (int i = 1; i < n; i++){
			if (position[i] - start <= l) // 시작지점에서 해당 거리가 l로  처리가능한지
				continue;
			else {
				start = position[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
