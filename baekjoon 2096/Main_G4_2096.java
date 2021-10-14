package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_2096 {
	static int n;
	static int[] map;
	static int[] dpMax;
	static int[] dpMin;
	static int max = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// 0, 1, 2번째를 나타냄.
		dpMax = new int[3];	// 최댓값 DP
		dpMin = new int[3];	// 최솟값 DP
		map = new int[3]; // 2차원 배열로 하려고 했지만 사용 가능 메모리가 작기때문에 1차원 배열로 했다.
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 한 줄씩 입력받아서 처리
			for(int j = 0; j < 3; j++) {
				int m = Integer.parseInt(st.nextToken());
				map[j] = m;
			}
			
			// 맨 처음 값들을 입력해주기
			if(i == 0) {
				dpMax[0] = dpMin[0] = map[0];
				dpMax[1] = dpMin[1] = map[1];
				dpMax[2] = dpMin[2] = map[2];
				continue;
			}
			
			// dp의 0번지와 1번지에 값을 바로 넣어서 dp[2]에 값이 이상해짐
			// 그걸 막기 위한 변수
			int max0 = dpMax[0];
			int min0 = dpMin[0];
			
			int max1 = dpMax[1];
			int min1 = dpMin[1];
			
			// 해당 칸 마다 올수있는 최대 값 구하기
			// [n]에는 현재 값 + 이전에 올수 있는 곳들 중 큰 값이 와야한다.
			// 0일 경우 0과 1에서 올 수 있고
			// 1일 경우 0과 1과 2에서 올 수 있고
			// 2일 경우 1과 2에서 올 수 있다.
			// 이건 최소값도 마찬가지이기 때문에 똑같은 로직으로 처리한다.
			dpMax[0] = map[0] + Math.max(dpMax[0], dpMax[1]);
			dpMax[1] = map[1] + Math.max(max0, Math.max(dpMax[1], dpMax[2]));
			dpMax[2] = map[2] + Math.max(max1, dpMax[2]);
			
			// 해당 칸 마다 올수있는 최소 값 구하기			
			dpMin[0] = map[0] + Math.min(dpMin[0], dpMin[1]);
			dpMin[1] = map[1] + Math.min(min0, Math.min(dpMin[1], dpMin[2]));
			dpMin[2] = map[2] + Math.min(min1, dpMin[2]);
		}
		
		// 마지막까지 돌면 각 칸에 올 때의 최대 값을 들고온다.
		// 그 중에서 최고를 구한다.
		for(int i = 0; i < 3; i++) {
			max = Math.max(max, dpMax[i]);
		}
		
		// 마지막까지 돌면 각 칸에 올 때의 최소 값을 들고온다.
		// 그 중에서 최소를 구한다.
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, dpMin[i]);
		}
		
		System.out.println(max + " " + min);
	}
}