package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_B3_3009 {
	static HashSet<Integer> x; 
	static HashSet<Integer> y; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = new HashSet<>(); // x의 좌표값을 담기 위한 hashset
		y = new HashSet<>(); // y의 좌표값을 담기 위한 hashset
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// x의 값 임의변수 n1, y의 값 임의변수 n2
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// 이미 있다면 제거해주고 없다면 추가
			if (x.contains(n1)) {
				x.remove(n1);
			}
			else {
				x.add(n1);
			}
			
			if (y.contains(n2)) {
				y.remove(n2);
			}
			else {
				y.add(n2);
			}
		}
		// 안에 있는 값을 출력하기 위한 Iterator
		Iterator<Integer> xiter = x.iterator();
		Iterator<Integer> yiter = y.iterator();
        while(xiter.hasNext()) {
            System.out.print(xiter.next() +" ");
        }
        while(yiter.hasNext()) {
            System.out.println(yiter.next());
        }
	}
}
