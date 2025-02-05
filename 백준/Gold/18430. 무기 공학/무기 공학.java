import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M,MAX = 0;
    static int[][] arr;
    static boolean[][] visited;
    static final int[][] dir = {{0, -1},{1, 0},{0, 1},{-1, 0}};

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    public static void process(){
        visited = new boolean[N][M];
        buildBoomerang(0,0,0);
        System.out.println(MAX);
    }

    public static void buildBoomerang(int x, int y, int sum) {
        if(y == N) {
            MAX = Math.max(MAX, sum);
            return;
        }
        
        if(x >= M) {
            buildBoomerang(0, y+1, sum);
            return;
        }
        
        if(visited[y][x]) {
            buildBoomerang(x+1, y, sum);
            return;
        }
        
        visited[y][x] = true;

        int centerValue = arr[y][x] * 2;

        for(int k=0; k<4; k++) {
            int nx1 = x + dir[k][0];
            int ny1 = y + dir[k][1];

            int nx2 = x + dir[(k+1)%4][0];
            int ny2 = y + dir[(k+1)%4][1];

            if(!isCanExpand(nx1, ny1) || !isCanExpand(nx2, ny2))
                continue;

            visited[ny1][nx1] = visited[ny2][nx2] = true;
            buildBoomerang(Math.max(nx1, nx2) + 1, y, sum + arr[ny1][nx1] + arr[ny2][nx2] + centerValue);
            visited[ny1][nx1] = visited[ny2][nx2] = false;
        }

        visited[y][x] = false;

        buildBoomerang(x+1, y, sum);
    }

    public static boolean isCanExpand(int x, int y) {
        if(x < 0 || y < 0 || x >= M || y >= N)
            return false;

        if(visited[y][x])
            return false;

        return true;
    }
}