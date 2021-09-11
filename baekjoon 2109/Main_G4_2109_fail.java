package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_2109_fail {
	static int n;
	static PriorityQueue<Que> queue;
	static int result;

	public static class Que implements Comparable<Que> {
		int p;
		int d;
		
		public Que(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Que o) {
			int value = d - o.d;
			if (value != 0)
				return value;
			else
				return o.p - p;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<Que>();

        for(int i = 0 ; i < n; i++){
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            queue.add(new Que(a, b));
        }
        
        int day = 0;
        
        for (int i = 0; i < n; i++) {
        	Que str = queue.poll();
        	
        	if (day != str.d) {
        		result += str.p;
        		day = str.d;
        	}
        }
        System.out.println(result);
	}
}