package BOJ_silver;

import java.io.*;
import java.util.*;

public class Main_S5_11292 {
	static int n;
	static int h;
	static int max;
	static ArrayList<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			
			max = 0;
			list = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), ". ");
				
				String name = st.nextToken();
				h = Integer.parseInt(st.nextToken()) * 100;
				h += Integer.parseInt(st.nextToken());
				
				if (max < h) {
					list.clear();
					list.add(name);
					max = h;
				}
				else if (max == h) {
					list.add(name);
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}