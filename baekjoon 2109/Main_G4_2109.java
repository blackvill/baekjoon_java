package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_2109 {
	static int n;
	static PriorityQueue<Que> queue;
	static int result;
	static int maxday;
	
	static boolean[] checked;

	public static class Que implements Comparable<Que> {
		int p;
		int d;
		
		public Que(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Que o) {
			if (o.p > p)
				return 1;
			else if (o.p == p) {
				if (o.d < d)
					return 1;
			}
			return -1;
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
            
            maxday = Math.max(b, maxday);
            queue.add(new Que(a, b));
        }
        
        checked = new boolean [maxday + 1];
        
        while(!queue.isEmpty()) {
        	Que str = queue.poll();
        	for(int i = str.d; i >= 1; i--) {
				if(!checked[i]) {
					checked[i] = true;
					result += str.p;
					break;
				}
			}
        }
        System.out.println(result);
	}
}
