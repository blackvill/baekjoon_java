package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_S1_1991 {
	static Map<String, List<String>> map = new HashMap<>();
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		 
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			List<String> list = new ArrayList<>();
			
			list.add(str[1]); list.add(str[2]);
			map.put(str[0], list);
		}
		
		preorder("A");
		System.out.println();
		
		inorder("A");
		System.out.println();
		
		postorder("A"); 
	}
	
	private static void preorder(String s) {
		if(s.equals(".")) return;

		System.out.print(s);
		preorder(map.get(s).get(0));
		preorder(map.get(s).get(1));
	}

	private static void inorder(String s) {
		if(s.equals(".")) return;

		inorder(map.get(s).get(0));
		System.out.print(s);
		inorder(map.get(s).get(1));
	}

	private static void postorder(String s) {
		if(s.equals(".")) return;
		
		postorder(map.get(s).get(0));
		postorder(map.get(s).get(1));
		System.out.print(s);
	}
}