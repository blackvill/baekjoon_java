package BOJ_silver;

import java.util.Scanner;

public class Main_S2_11724 {
	static int n;
	static int m;
	static int count;
    static boolean visits[];
    static boolean map[][];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        visits = new boolean[n + 1];
        map = new boolean[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            map[a][b] =  map[b][a] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            if (!visits[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    
    private static void dfs(int a) {
        visits[a] = true;
        
        for(int i = 1; i <= n; i++) {
            if (map[a][i] && !visits[i]) {
                dfs(i);
            }
        }
    }
}