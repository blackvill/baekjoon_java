package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1388_김재욱 {
	static int r;
	static int c;
	static char[][] map;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new char[c][r];
        
        for (int i = 0; i < c; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        // -의 개수 확인
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (map[i][j] == '-') {
                    cnt++; // 총 개수를 증가시키고
                    while (j < r && map[i][j] == '-') {
                    	// -로 연결된 것을 다 처리
                        j++;
                    }
                }
            }
        }

        // |의 개수 확인
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[j][i] == '|') {
                    cnt++; // 총 개수를 증가시키고
                    while (j < c && map[j][i] == '|') {
                    	// |로 연결된 것을 다 처리
                        j++;
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
}