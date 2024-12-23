import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final int N = 5;
    static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] map = new int[N][N];
    static int X,Y;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    }

    public static void process(){
        dfs(X, Y, 0, 0);
        System.out.println(0);
    }

    static void dfs(int x, int y, int eatCnt, int depth) {
        if(map[y][x] == 1)
            eatCnt++;

        if(depth >= 3) {
            if(eatCnt >= 2) {
                System.out.println(1);
                System.exit(0);
            }

            return;
        }

        for(int k=0; k<dir.length; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;

            if(map[ny][nx] == -1)
                continue;

            map[y][x] = -1;

            dfs(nx, ny, eatCnt, depth + 1);

            map[y][x] = 0;
        }
    }
}