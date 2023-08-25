import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M,ans,T;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}, map;
    public static void main (String[] args) throws IOException  {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X

        map = new int[N][M];
        visit = new boolean[N][M];

        int a,b,c;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                map[i][j] = (a+b+c)/3;
            }
        }

        T = Integer.parseInt(br.readLine());
    }

    public static void process() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = (map[i][j] >= T) ? 255 : 0;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 255 && !visit[i][j]) {
                    DFS(j,i);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void DFS(int x, int y) {
        visit[y][x] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(visit[ny][nx]) continue;
            if(map[ny][nx] != 255) continue;
        
            DFS(nx, ny);
        }
    }
}