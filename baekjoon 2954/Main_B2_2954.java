package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2_2954 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 값을 입력받기 위한 bufferedReader 선언

        String str = br.readLine();
        str = str.replace("apa", "a").replace("epe", "e").replace("ipi", "i").replace("opo", "o").replace("upu", "u");
        System.out.println(str);
    }
}
