package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_B2_11365 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		stack = new Stack<>();
		
		while (true) {
			String str = br.readLine();
			
			if (str.compareTo("END") == 0)
				break;
			
			char[] tochar = str.toCharArray();
			for (int i = 0; i < tochar.length; i++) {
				stack.add(tochar[i]);
			}
			for (int i = 0; i < tochar.length; i++) {
				System.out.print(stack.pop());
			}
			System.out.println();
		}
	}
}
