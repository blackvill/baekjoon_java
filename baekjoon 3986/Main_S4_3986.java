package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_3986 {
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> s = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				if (!s.isEmpty() && s.peek() == str.charAt(j)) 
					s.pop();
				else
					s.push(str.charAt(j));
			}
			if (s.isEmpty())
				count++;
		}
		System.out.println(count);
	}

}
