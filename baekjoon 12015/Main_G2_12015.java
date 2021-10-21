package BOJ_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G2_12015 {
	static int n;
	static int[] arr;
	static List<Integer> list;
	static int left;
	static int mid;
	static int right;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < n; i++) {
        	// 값 입력 받기
            int value = arr[i] = Integer.parseInt(st.nextToken());
            
            if(value > list.get(list.size() - 1))
            	list.add(value);
            else{
                left = 0;
                right = list.size() - 1;

                while(left < right){
                    mid = (left + right) >> 1;
                    if(list.get(mid) >= value){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(right, value);
            }
        }
        System.out.println(list.size() - 1);
    }
}