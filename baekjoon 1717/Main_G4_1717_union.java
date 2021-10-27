package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1717_union {
	static int n;
	static int m;
	static int parents[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n + 1];
		
		makeSet();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (op == 0) {
				union(a, b);
			}
			else if (op == 1) {
				check(a, b);
			}
		}
	}
	
	public static void makeSet() {
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int i) {
		if (parents[i] == i)
			return i;
		
		return parents[i] = find(parents[i]);
	}
	
	public static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if (i != j) {
			parents[j] = i;
		}
	}
	
	public static void check(int i, int j) {
		i = find(i);
		j = find(j);
		
		if (i == j)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}