package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_S5_2751 {
	static int n;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) 
			sb.append(list.get(i)+ "\n");
		
		System.out.println(sb);
	}
}