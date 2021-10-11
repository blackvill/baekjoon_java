package BOJ_silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S1_7569 {
	static int M;
	static int N;
	static int H;
	static int map[][][];
	static boolean visited[][][];
	static Queue<tomato> q;
	static int result;
	
	static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    
    public static class tomato{
        int x,y,z;

        public tomato(int x,int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        q = new LinkedList<>();

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    map[i][j][k] = sc.nextInt();
                    
                    if(map[i][j][k] == 1){
                        q.add(new tomato(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        
        result = bfs();
        System.out.println(result);
    }
    
    public static int bfs() {
    	while(!q.isEmpty()){
            tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            int z = t.z;

            for(int i = 0; i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx<H && ny < N && nz < M){
                    if(map[nx][ny][nz] == 0 && !visited[nx][ny][nz]){
                        q.add(new tomato(nx,ny,nz));
                        map[nx][ny][nz] = map[x][y][z] + 1;
                    }
                }
            }
        }
        int max = 0;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(map[i][j][k] == 0){
                        return -1;
                    }
                    if(max < map[i][j][k]) {
                        max = map[i][j][k];
                    }
                }
            }
        }
        
        return max - 1;
    }
}