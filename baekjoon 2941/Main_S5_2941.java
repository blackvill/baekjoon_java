package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_2941 {
	static String str;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		str = br.readLine();
 
		for (int i = 0; i < str.length(); i++) {
 
			char c = str.charAt(i);
 
			
			// c= or c-
			if(c == 'c') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;		
					}
					else if(str.charAt(i + 1) == '-') {
						i++;
					}
				}
			}
			// dz= or d-
			else if(c == 'd') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'z') {
						if(i < str.length() - 2) {
							if(str.charAt(i + 2) == '=') {
								i += 2;
							}
						}
					}
					else if(str.charAt(i + 1) == '-') {
						i++;
					}
				}
			}
			// lj
			else if(c == 'l') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {
						i++;
					}
				}
			}
			// nj
			else if(c == 'n') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {
						i++;
					}
				}
			}
			// s=
			else if(c == 's') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;
					}
				}
		    }
			// z=
			else if(c == 'z') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;
					}
				}
			}
		    
			count++;
		}
 
		System.out.println(count);
	}
}