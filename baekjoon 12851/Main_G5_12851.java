package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_12851_김재욱 {
	static int n;
	static int k;
    static boolean[] visited = new boolean[100001];
    static int time = 0;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 두 사람이 같은 장소에 있는 경우
        if(n == k){
            System.out.println("0 \n1"); // 횟수는 0이고 경우의 수는 1이니까 바로 출력
        }else { // 아니라면
            bfs(n); // bfs 탐색
            
            // 결과 출력
            System.out.println(time + "\n" + count);
        }
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            // 만난 경우가 1번이라도 있으면 다음 계산부터는 최소가 아님
            if(count != 0) {
                return;
            }

            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                // 현재 위치를 방문 처리
                visited[now] = true;
                
                int next;

                // 이전 칸으로 이동하는 경우
                next = now - 1;
                if (next == k) {
                    count++;
                } else if (next >= 0 && !visited[next]) {
                	// 감소되는 것이기 때문에 혹시라도 배열의 범위를 벗어나면 안되므로 0보다 큰지 체크
                    q.offer(next);
                }

                // 다음 칸으로 이동하는 경우
                next = now + 1;
                if (next == k) {
                    count++;
                } else if (next < 100001 && !visited[next]) {
                	// 최대 위치가 100000이므로 이 범위안에 포함이 되는지 체크
                    q.offer(next);
                }

                // 2배의 위치로 순간이동을 하는 경우
                next = now * 2;
                if(next == k) {
                    count++;
                } else if (next < 100001 && !visited[next]) {
                	// 최대 위치가 100000이므로 이 범위안에 포함이 되는지 체크
                    q.offer(next);
                }
            }
            
            time++;
        }
    }
}