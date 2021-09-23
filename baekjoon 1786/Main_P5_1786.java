package BOJ_platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_P5_1786 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] target = br.readLine().toCharArray(); // 기존의 문자열
		char[] pattern = br.readLine().toCharArray(); // 찾을 문자열
		
		int tSize = target.length;
		int pSize = pattern.length;
		
		if (tSize < pSize) {
			System.out.println(0);
		}
		else {
			int base = 26; // (A~Z)문자열로 하기 때문에
			int mod = (int)1e9 + 7;
			long power = 1;
			long tHash = 0, pHash = 0; // 타겟의 해쉬와 패턴의 해쉬
			
			for (int i = 0; i < pSize; i++) {
				pHash = (pHash * base + pattern[i]) % mod;
				tHash = (tHash * base + target[i]) % mod;
				
				if (i != 0) power = (power * base) % mod;
			}
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 0, end = tSize - pSize; i <= end; i++) {
				if (pHash == tHash)
					list.add(i + 1);
				if (i + pSize == tSize)
					break;
				
				tHash = (base * (tHash - target[i] * power) + target[i + pSize]) % mod;
				if (tHash < 0)
					tHash += mod;
			}
			
			System.out.println(list.size());
			
			for (Integer idx : list) {
				System.out.print(idx + " ");
			}
		}
	}
}