package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B1_12605_김재욱 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			Stack<String> stack = new Stack<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 입력할 것이 없을때까지 stack에 추가
			while (st.hasMoreTokens()) {
				stack.add(st.nextToken());
			}
			
			// 출력
			System.out.print("Case #" + i + ": ");
			
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}
}