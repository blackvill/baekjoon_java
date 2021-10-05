package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2531 {
	static int n; // 벨트에 접시의 수
	static int d; // 초밥의 가짓수
	static int k; // 연속해서 먹는 접시의 수
	static int c; // 쿠폰 번호
	static int selected[]; // 연속해서 먹을 때 선택된 접시
	static int dish[]; // 벨트에 있는 초밥
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dish = new int[n];
		selected = new int[3001]; // 최대 3000개
		
		// 접시 입력받기
		for (int i = 0; i < n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		// k개의 수만큼 연속해서 먹으니까
		for (int i = 0; i < k; i++) {
			if (selected[dish[i]] == 0) // 선택되지 않은 것이라면
				count++; // count의 값을 증가
			selected[dish[i]]++; // 해당 값을 증가
		}
		int result = count; // 처음부터 k개를 선택했을때의 result
		
		// 처음에 k만큼을 채웠으니
		// 맨앞에꺼를 빼주고 뒤에 1개를 증가시켜주면서 계산
		for (int i = 0; i < n; i++) {
			if (result <= count) { // 최대값을 갱신
				if (selected[c] == 0) // 쿠폰에 해당하는 것이 선택되어 있지 않다면
					result = count + 1; // 쿠폰거 먹을 수 있으니까 +1
				else // 선택되어 있으면
					result = count; // 그냥 그대로
			}
			// 맨 앞의 것을 빼주고
			if (selected[dish[i]] == 1) // 1번만 선택이 된 것이라면
				count -= 1; // 카운트 - 1
			selected[dish[i]]--; // 해당 위치값 감소
			
			// 새로운 것을 추가
			// (i + k - 1)로 하면 값의 범위를 벗어나지만
			// 회전 초밥의 경우 순환적이기 때문에
			// n으로 나눠서 처리 가능
			if (selected[dish[(i + k) % n]] == 0) // 선택되어 있지 않다면
				count += 1; // 추가하는거니까 +1
			selected[dish[(i + k) % n]]++; // 해당 위치값 증가
		}
		
		System.out.println(result);
	}
}
