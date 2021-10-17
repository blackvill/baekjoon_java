package BOJ_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_10798 {
	static char map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][15];
    	
        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(map[j][i] == '\0')
                    continue;
                System.out.print(map[j][i]);
            }
        }
    }
}