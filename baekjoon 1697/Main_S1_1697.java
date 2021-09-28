package BOJ_silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S1_1697 {
	static int n;
    static int k;
    static int result;
    static int[] visited = new int[100001];
    
    static int[] delta = {1, -1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        
        if (n == k) { // 시작과 도착이 같으면 바로 도착이기 때문에 0으로 준다.
        	result = 0;
        }
        else {
        	result = bfs(n);
        }
        System.out.println(result);
    }

    public static int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 2) {
                	next = cur * delta[i];
                } else {
                    next = cur + delta[i];
                }

                if (next == k) {
                    return visited[cur];
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
        return 0;
    }
}
