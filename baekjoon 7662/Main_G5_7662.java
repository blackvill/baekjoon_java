package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_G5_7662 {
	static int tc;
	static int k;
	static TreeMap<Long, Long> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			k = Integer.parseInt(br.readLine());
			map = new TreeMap<>();

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				char cmd = st.nextToken().charAt(0);
				long num = Integer.parseInt(st.nextToken());

				if(cmd == 'I') {
					if(map.containsKey(num))
						map.put(num, map.get(num) + 1);
					else
						map.put(num, 1L);
				}
				else if(cmd == 'D') {
					if(map.isEmpty())
						continue;
					if(num == -1) {
						long minKey = map.firstKey();
						long next = map.get(minKey) - 1;
						
						if(next == 0)
							map.remove(minKey);
						else
							map.put(minKey, next);
					}
					else if(num == 1) {
						long maxKey = map.lastKey();
						long next = map.get(maxKey) - 1;
						
						if(next == 0)
							map.remove(maxKey);
						else
							map.put(maxKey, next);
					}
				}
			}
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}