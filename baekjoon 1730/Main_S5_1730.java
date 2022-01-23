package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S5_1730 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
        	Arrays.fill(map[i], '.');
        }
        
        int x = 0; // x좌표
        int y = 0; // y좌표
        
        for(int i = 0; i < s.length(); i++) {
            char move = s.charAt(i); // 이동 커맨드
            
            if (move == 'D') { // 만약 아래로라면
            	// 범위 유효성 체크
                if(x < n-1) {
                	// . 즉, 커맨드가 없는 칸이라면
                    if(map[x][y] == '.') {
                        map[x][y] = '|'; // 아래로 그림
                    } else if(map[x][y] == '-') { // 만약 -라면
                        map[x][y] = '+'; // +
                    }
                    x++; // 행으로 한칸 이동
                    // 이동한 곳으로도 커맨드가 적용
                    if(map[x][y] == '.') {
                        map[x][y] = '|';
                    }else if(map[x][y] == '-') {
                        map[x][y] = '+';
                    }
                }
            }
            else if (move == 'U') { // 위로라면
            	// 범위 유효성 체크
                if(x > 0) {
                    if(map[x][y] == '.') {
                        map[x][y] = '|';
                    }else if(map[x][y] == '-') {
                        map[x][y] = '+';
                    }    
                    x--;
                    if(map[x][y] == '.') {
                        map[x][y] = '|';
                    }else if(map[x][y] == '-') {
                        map[x][y] = '+';
                    }
                }
            }
            else if (move == 'L') { // 왼쪽으로 라면
            	// 범위 유효성 체크
                if(y > 0) {
                    if(map[x][y] == '.') {
                        map[x][y] = '-';
                    }else if(map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                    y--;
                    if(map[x][y] == '.') {
                        map[x][y] = '-';
                    }else if(map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                }
            }
            else if (move == 'R') { // 오른쪽으로 라면
            	// 범위 유효성 체크
                if(y < n-1) {
                    if(map[x][y] == '.') {
                        map[x][y] = '-';
                    }else if(map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                    y++;
                    if(map[x][y] == '.') {
                        map[x][y] = '-';
                    }else if(map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                }
            }
        }
        
        // 결과 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}