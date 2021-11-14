package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S5_8919 {
	static int N; // 국가의 수
	static int K; // 국가의 번호
	static int ranking; // 등수
	
	static class Country implements Comparable<Country> {
		int C; // 국가 번호
		int G; // 금메달
		int S; // 은메달
		int B; // 동메달
		
		public Country(int c, int g, int s, int b) {
			C = c;
			G = g;
			S = s;
			B = b;
		}
		
		@Override
		public int compareTo(Country o) {
			if (G > o.G) // 금메달 내림차순 정렬
				return -1;
			else if (G == o.G) { // 금메달의 개수가 같으면
				if (S > o.S) // 은메달 내림차순 정렬
					return -1;
				else if (S == o.S) { // 은메달의 개수가 같다면
					if (B > o.B) // 동메달 내림차순 정렬
						return -1;
				}
			}
			return 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 우선순위큐에 담아주기
		PriorityQueue<Country> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int index = Integer.parseInt(st.nextToken()); // 국가의 번호
			int g = Integer.parseInt(st.nextToken()); // 금메달
			int s = Integer.parseInt(st.nextToken()); // 은메달
			int b = Integer.parseInt(st.nextToken()); // 동메달
				
			pq.add(new Country(index, g, s, b));
		}
		
		// 1등부터 시작하니까 1
		ranking = 1;
		
		Country country = pq.poll();
		
		// 만약 1등인 경우라면 바로 출력해주기
		if (country.C == K) {
			System.out.println(ranking);
			System.exit(0);
		}
		
		// 아니라면 공동순위가 발생할 수 있으니까 아래에서 처리
		int equal = 0; // 공통의 수
		
		while (!pq.isEmpty()) {
			Country c = pq.poll(); // 비교할 대상을 빼낸다.
			
			// 만약에 금메달, 은메달, 동메달의 수가 같다면
			if (country.G == c.G && country.S == c.S && country.B == c.B) {
				equal++; // 공통 수를 증가
			}
			else { // 다르다면
				country = c; // 현재 비교하는 국가를 넣고  
				ranking++; // 랭킹을 증가시킨다.
				
				if (equal > 0) { // 만약 공통된 수가 있다면
					ranking += equal; // 랭킹을 그만큼 더 추가한다.
					equal = 0; // 공통 순위를 처리해줬으니 다시 0으로 초기화
				}
			}
			
			// 비교하는 국가가 알고싶은 국가라면 랭킹 출력 후 종료
			if (c.C == K) {
				System.out.println(ranking);
				System.exit(0);
			}
		}
	}
}