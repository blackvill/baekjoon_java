package BOJ;

import java.util.Scanner;

// 같은 행에 두지 않는 방식
// n개의 퀸을 위협적이지 않게 놓는 모든 경우의 수

public class Main_G5_9663 {
	static int n;
	static int col[]; // 같은 행에 두지 않으므로 1차원이면 충분
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		col = new int[n + 1];
		cnt = 0;
		
		setQueens(1);
		System.out.println(cnt);
	}
	
	private static void setQueens(int rowNo) {
		if (rowNo > n) { // 1행부터 쓰니까 (rowNo == n)이면 마지막을 생략한다.
			cnt++;
			return;
		}
		// 현재 퀸 1열부터 n열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <= n; i++) {
			col[rowNo] = i;  // i열에 놓기
			if (isAvailable(rowNo)) {
				setQueens(rowNo + 1);
			}
		}
	}
	
	private static boolean isAvailable(int rowNo) { //유효성 검사는 직전 행
		for (int i = 1; i < rowNo; i++) { // i : 이전 퀸
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == (rowNo - i))
				return false;
		}
		return true;
	}
}