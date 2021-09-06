package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
 
 
public class Main_S5_1181 {
	static int n;
	static String[] str;
	
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		n = Integer.parseInt(br.readLine());
		str = new String[n];
 
		for (int i = 0; i < n; i++)
			str[i] = br.readLine();
		
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length())
					return s1.compareTo(s2);
				else
					return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < n; i++) {
			if (i > 0 && str[i].compareTo(str[i-1]) == 0)
				continue;
			else  
				System.out.println(str[i]);
		}
	}
}
