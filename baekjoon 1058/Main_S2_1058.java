package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S2_1058 {
	static int n;
	static int arr[][];
	static int max = Integer.MAX_VALUE >> 2; // 최대값을 주기
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        
        // 값 입력받기
        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            
            for(int j = 1; j <= n; j++) {
                char ch = str.charAt(j - 1);
                
                if(ch == 'Y')
                    arr[i][j] = 1;
                else if(i != j)
                    arr[i][j] = max;
            }
        }
        
        // 플루이드 와샬
        for(int k = 1; k <= n; k++) { // 경유지
            for(int i = 1; i <= n; i++) { // 출발지
                for(int j = 1; j <= n; j++) { // 도착지
                    if(i == j || j == k || i == k)
                        continue;
                    else if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int tmp = 0;
            
            for(int j = 1; j <= n; j++) {
                if(i == j) // 자기 자신은 건너뛰기
                    continue;
                // 2-친구인 경우
                else if(arr[i][j] <= 2)
                    tmp++;
            }
            // 더 큰 값으로 갱신
            ans = Math.max(ans, tmp);
        }
        
        // 결과 출력
        System.out.println(ans);
    }
}