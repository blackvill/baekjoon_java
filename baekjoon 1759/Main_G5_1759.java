package BOJ_gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_G5_1759 {
	static int l,c;
	static char pwd[];
	static boolean selected[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		c = sc.nextInt();
		
		pwd = new char[c];
		selected = new boolean[c];
		
		for(int i = 0; i < c; i++) {
			pwd[i] = sc.next().charAt(0);
		}
		
		// 입력된 알파벳들을 정렬
		Arrays.sort(pwd);
	
		comb(0, 0);
	}
	
	static void comb(int start, int cnt) {
		if(cnt == l) {
			int vowels = 0; // 모음 카운트
			int Consonants = 0; // 자음 카운트
			
			for(int i = 0; i < c; i++) {
				if (selected[i]) {
					// 모음인지 체크
					if (pwd[i]=='a' || pwd[i]=='e' || pwd[i]=='i'
							|| pwd[i]=='o' || pwd[i]=='u') {
						vowels++;
					}else {
						Consonants++;
					}			
				}
			}
			// 모음이 1글자 이상, 자음이 2글자 이상일 때
			if(vowels >= 1 && Consonants >= 2) {
				for(int i = 0; i < c; i++) {
					if (selected[i]) {
						System.out.print(pwd[i]);
					}
				}
				System.out.println();
			}
		}
		
		for(int i = start; i < c; i++) {
			selected[i] = true;
			comb(i + 1, cnt + 1);
			selected[i] = false;
		}
	}
}