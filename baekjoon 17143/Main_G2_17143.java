package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 열과 행으로만 이동하는 경우
 * (열 - 1) * 2 는 해당 열으로 돌아오는데 걸리는 횟수
 * (행 - 1) * 2 는 해당 행으로 돌아오는데 걸리는 횟수
 */

public class Main_G2_17143 {
	static int r;
	static int c;
	static int m;
	static Shark map[][]; // 객체 배열을 사용
	static ArrayList<Shark> sharklist; // 상어의 정보를 담기 위한 arraylist
	static int result; // 결과
	
	static int[] dr = {0, -1, 1, 0, 0}; // 행 방향
	static int[] dc = {0, 0, 0, 1, -1}; // 열 방향

	public static class Shark {
		int x; // x위치
		int y; // y위치
		int s; // 속력 
		int d; // 이동 방향
		int z; // 크기
		
		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 초기화
		map = new Shark[r][c];
		sharklist = new ArrayList<>();
		result = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken()) - 1;
			int S = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			
			Shark s = new Shark(R, C, S, D, Z);
			map[R][C] = s;
			sharklist.add(s);
		}
		
		for (int i = 0; i < c; i++) {
			sharkcatch(i); // 상어 잡기
			for (int j = 0; j < sharklist.size(); j++) { // 리스트 반복하면서 이동
				move(0);
				// 0을 이동시키는 이유는 기존의 것을 삭제하고 새로 추가하게 되면
				// 리스트의 가장 마지막으로 넘어가기 때문
			}
			mapping(); // 맵에 적용
		}
		
		System.out.println(result);
	}

	public static void sharkcatch(int y) {
		for (int i = 0; i < r; i++) { // 모든 행을 다 찾다가
			if (map[i][y] != null) { // 상어가 있다면
				Shark catched = map[i][y]; // 위치에 있는 상어를 catched
				map[i][y] = null; // 해당 위치를 null로 초기화
				
				result += catched.z; // 잡은 상어의 크기만큼 증가
				
				sharklist.remove(catched); // 리스트에서 제거
				
				return; // 한마리 잡으면 끝남
			}
		}
	}
	
	public static void move(int n) {
		Shark base = sharklist.get(n);
		int x = base.x;
		int y = base.y;
		int dest = base.d;
		int move = base.s;
		
		switch (dest) {
		case 1 : case 2 : // 상하 이동
			move %= (r - 1) * 2;
			while (move > 0) {
				if(x == 0) { // 끝에 다으면 방향 전환
					dest = 2;
				}
				if(x == r - 1) { // 끝에 닿으면 방향 전환
					dest = 1;
				}
				x += dr[dest];
				move--;
			}
			break;
		case 3 : case 4 : // 좌우 이동
			move %= (c - 1) * 2;
			while (move > 0) {
				if(y == 0) { // 끝에 다으면 방향 전환
					dest = 3;
				}
				if(y == c - 1) {// 끝에 다으면 방향 전환
					dest = 4;
				}
				y += dc[dest];
				move--;
			}
			break;
		}
		
		sharklist.add(new Shark(x, y, base.s, dest, base.z)); // 리스트에 새로 추가
		sharklist.remove(base); // 기존에 리스트에 있던 것을 지워준다.
	}
	
	public static void mapping() {
		map = new Shark[r][c]; // 맵을 새롭게 초기화
		
		for (int i = sharklist.size() - 1; i >= 0; i--) {
			// 0 ~ sharklist.size() 까지 하니까 remove되면서 순서가 달라져 결과값이 달라짐
			Shark shark = sharklist.get(i);
			
			if (map[shark.x][shark.y] == null) { // 비어있는 곳이라면
				map[shark.x][shark.y] = shark; // 현재 정보를 가진것을 배열에 저장
			}
			else { // 만약에 상어가 있다면
				// 상어의 크기를 비교해서
				// 기존의 상어가 작다면 해당 상어를 지우고 현재 상어를 저장
				// 기존의 상어가 크다면 현재 상어를 지운다.
				if (map[shark.x][shark.y].z > shark.z) {
					sharklist.remove(shark); // 제거
				}
				else {
					sharklist.remove(map[shark.x][shark.y]); // 제거
					map[shark.x][shark.y] = shark; // 갱신
				}
			}
		}
	}
}