package BOJ_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_1501_김재욱 {
	static int[][] arr = new int[10000][52];

    static int[] devide(String word) {
        int[] result = new int[52];

        for (int i = 1; i < word.length() - 1; i++) {
            int alphabet = word.charAt(i) - 'a';
            if (alphabet < 0)
                alphabet += 58;

            result[alphabet]++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
        	// 문자 입력받기
            str[i] = br.readLine();
            // 입력받은 문자를 각 알파벳별로 나누기
            arr[i] = devide(str[i]);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        //문장 별
        for (int i = 0; i < m; i++) {

            String[] word = br.readLine().split(" ");

            int result = 1;
            //단어 별
            for (int z = 0; z < word.length; z++) {
            
                int[] consist = devide(word[z]);
                int cnt = 0;

                //문장의 단어와 사전 속의 단어 비교 
                for (int j = 0; j < n; j++) {
                    boolean correct = true;

                    //두 단어 모두 길이가 2이상이고 첫 글자와 마지막 글자가 동일하지 않다면 skip
                    if (str[j].length() > 1 && word[z].length() > 1) {
                        if (str[j].charAt(0) != word[z].charAt(0) || str[j].charAt(str[j].length() - 1) != word[z].charAt(word[z].length() - 1))
                            continue;
                    }
                    //두 단어 모두 길이가 1이며 두 단어가 동일하지 않다면 skip
                    else if (str[j].length() == 1 && word[z].length() == 1) {
                        if (!str[j].equals(word[z])) continue;
                    }
                    //두 단어 중 하나만 길이가 1일 때는 skip
                    else if (str[j].length() == 1 || word[z].length() == 1)
                        continue;

                    for (int k = 0; k < 52; k++)
                        if (consist[k] != arr[j][k]) {
                            correct = false;
                            break;
                        }

                    if (correct) cnt++;
                }
                
                result *= cnt;
            }
            
            System.out.println(result);
        }
    }
}