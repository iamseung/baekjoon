import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map, dp, dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N, MAX;

    public static void main(String[] args) throws IOException {    
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        MAX = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                MAX = Math.max(DFS(j, i), MAX);
            }
        }

        System.out.println(MAX);
    }

    public static int DFS(int x, int y) {
        if(dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1;
        
        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(map[y][x] >= map[ny][nx]) continue;

            dp[y][x] = Math.max(dp[y][x], DFS(nx, ny)+1);
        }

        return dp[y][x];
    }
}