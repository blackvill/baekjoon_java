package baekjoon;

import java.util.Scanner;

public class baekjoon_13565 {
	static int c, r;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag = false;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		map = new int[c][r];
		for (int i = 0; i < c; i++)
		{
			String s = sc.next();
			for (int j = 0; j < r; j++)
				map[i][j] = (int)s.charAt(j) - 48;
		}
		for (int i = 0; i < r; i++)
		{
			if (flag == true)
				break;
			if (map[0][i] == 0)
			{
				visited = new boolean[c][r];
				visited[0][i]=true;
				dfs(0,i);
			}
		}
		if (flag == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	private static void dfs(int x, int y) {
		if (x == (c - 1)) {
			flag = true;
			return ;
		}
		for (int i = 0; i < 4; i++)
		{
			int X = x + dx[i];
			int Y = y + dy[i];
			if(X < 0 || Y < 0 || X >= c || Y >= r)
				continue;
			if(map[X][Y] == 0 && !visited[X][Y])
			{
				visited[X][Y] = true;
				dfs(X,Y);
			}
		}
	}
}