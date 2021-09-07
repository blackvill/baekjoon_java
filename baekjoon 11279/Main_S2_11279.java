package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_S2_11279 {
	static int n;
	static PriorityQueue<Que> queue;

	public static class Que implements Comparable<Que> {
		int num;
		
		public Que(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Que o) {
			return o.num - num;
		}
		
		@Override
		public String toString() {
			return num + "\n";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<Que>();

        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){ // 0일 경우 출력
                if(queue.isEmpty()) // 큐가 비었다면
                	System.out.println("0"); // 0출력
                else
                	System.out.print(queue.poll()); //아니면 큐에서 꺼내기 
            }else // 아니면
                queue.offer(new Que(val)); //입력 
        }
	}
}