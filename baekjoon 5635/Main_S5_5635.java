package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S5_5635 {
	static int n;
	static String str[][]; // 정보입력

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
        str = new String[n][4]; // 이름, 일, 월, 년
 
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken(); // 이름
            str[i][1] = st.nextToken(); // 일
            str[i][2] = st.nextToken(); // 월
            str[i][3] = st.nextToken(); // 년
            
            
            // 이렇게 해주지 않으면 12가 9보다 작다는 결과가 나온다
            if (str[i][1].length() == 1) // 입력받은 일이 1자리수 (1~9)일 경우 앞에 0을 추가로 붙여준다.
            	str[i][1] = "0" + str[i][1];
            
            if (str[i][2].length() == 1) // 입력받은 달이 1자리수 (1~9)일 경우 앞에 0을 추가로 붙여준다.
            	str[i][2] = "0" + str[i][2]; 
        }
 
        // 정렬 재정의
        Arrays.sort(str, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[3].compareTo(o2[3]) == 0) {
                    if (o1[2].compareTo(o2[2]) == 0) {
                        return o1[1].compareTo(o2[1]);
                    } else {
                        return o1[2].compareTo(o2[2]);
                    }
                }
                return o1[3].compareTo(o2[3]);
            }
        });
 
        // 출력
        System.out.println(str[n - 1][0] + "\n" + str[0][0]);
    }
}