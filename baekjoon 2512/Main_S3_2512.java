package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_2512 {
	static int n; // 지방의 수
	static long m; // 총 예산
	static int[] arr; // 지방 예산
    static long ans = 0;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Long.parseLong(br.readLine());
        
        // 정렬
        Arrays.sort(arr);
        
        // 왼쪽, 오른쪽 포인터
        long left = 0;
        long right = arr[n - 1];
        
        // 왼쪽이 오른쪽보다 크거나 같아지면 종료
        while (left <= right) {
        	// 상한가를 mid로 설정
            long mid = (left + right) / 2;
            long sum = 0; // 모든 지방 세금 합
            
            for (int money : arr) {
                if (money >= mid)
                	sum += mid; //내라는 세금 낼 수 있는 지방
                else
                	sum += money; //못내는 지방은 가진 최대 돈만 냄
            }
            // 주어진 총 세금보다 모든 지방에서 받은 세금 합이 큰 경우
            if (sum > m) {
                right = mid - 1; // 세금을 줄이기
            }
            // 주어진 세금보다 모든 지방에서 받은 세금 합이 작은 경우
            else {
                left = mid + 1; // 세금을 올리기
                ans = Math.max(ans, mid); // 더 큰 값으로 변경
            }
        }
        System.out.println(ans);
    }
}