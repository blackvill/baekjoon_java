package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S3_14235 {
	static long n;
	static PriorityQueue<Present> queue;
	
	public static class Present implements Comparable<Present> {
		int present;

		public Present(int present) {
			this.present = present;
		}
		
		@Override
		public int compareTo(Present o) {
			return o.present - present;
		}
		
		@Override
		public String toString() {
			return present + "";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
        queue = new PriorityQueue<Present>();
        
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	if (num == 0) {
        		if (queue.isEmpty())
        			System.out.println("-1");
        		else
        			System.out.println(queue.poll());
        	}
        	else {
        		for (int j = 0; j < num; j++) {
        			int value = Integer.parseInt(st.nextToken());
        			queue.offer(new Present(value));
        		}
        	}
        }
	}
}