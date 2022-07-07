package BOJ_bronze;

import java.io.*;
import java.util.*;

public class Main_B1_9093 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); 

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String sentence = br.readLine() + "\n"; 
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == ' ' || sentence.charAt(j) == '\n') { 
                    while (!stack.empty()) { 
                        sb.append(stack.pop()); 
                    }
                    sb.append(sentence.charAt(j)); 
                } 
                else {
                    stack.push(sentence.charAt(j)); 
                }
            }
        }

        System.out.print(sb.toString());
	}
}