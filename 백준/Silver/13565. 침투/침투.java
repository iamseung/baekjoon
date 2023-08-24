import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static char[][] area;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean arrived = false;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), ". ");
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X

        area = new char[N][M];
        visit = new boolean[N][M];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                area[i][j] = str.charAt(j);
            }
        }
    }

    public static void process() {
        for(int t=0; t<M; t++) {
            if(area[0][t] == '0') DFS(t, 0);
        }

        System.out.println((arrived) ? "YES" : "NO");
    }

    public static void DFS(int x, int y) {
        if(y == N-1) {
            arrived = true;
            return;
        }

        visit[y][x] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0||ny<0||nx>=M||ny>=N) continue;
            if(visit[ny][nx]) continue;
            if(area[ny][nx] == '1') continue;

            DFS(nx, ny);
        }
    }
}
