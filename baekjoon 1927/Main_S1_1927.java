package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_S1_1927 {
	static int n;
	static PriorityQueue<Integer> queue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>();

        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){ // 0일 경우 출력
                if(queue.isEmpty()) // 큐가 비었다면
                	System.out.println("0"); // 0출력
                else
                	System.out.println(queue.poll()); //아니면 큐에서 꺼내기 
            }else // 아니면
                queue.add(val); //입력 
        }
	}
}