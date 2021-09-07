package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_15903 {
	static long n;
	static long m;
	static long result;
	static PriorityQueue<Long> queue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
        queue = new PriorityQueue<Long>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	queue.offer(Long.parseLong(st.nextToken()));
        }
        
        for (int i = 0; i < m; i++) {
        	long a = queue.poll();
        	long b = queue.poll();
        	long sum = a + b;
        	
        	queue.offer(sum);
        	queue.offer(sum);
        }
        
        for (int i = 0; i < n; i++) {
        	result += queue.poll();
        }
        
        System.out.println(result);
	}
}