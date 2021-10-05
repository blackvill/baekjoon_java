package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_S3_13414 {
	static int k;
	static int l;
	static String str;
	static LinkedHashSet<String> set; // 순서를 알아야하기 때문에 LinkedHashSet
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		set = new LinkedHashSet<>();
		
		for(int i = 0; i < l; i++){
			str = br.readLine();
			
			if(set.contains(str)) // 이미 있는 항목이라면
				set.remove(str); // 제거하고
			set.add(str); // 추가
		}
		
		Iterator<String> iter = set.iterator();
		
        while(iter.hasNext()) {
            System.out.println(iter.next());
            if(--k == 0) break;
        }
		
//		for (int i = 0; i < k; i++) {
//			System.out.println(iter.next());
//		}
	}
}