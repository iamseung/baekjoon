import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,cnt;
    static int[][] area;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{-1,-1},{1,-1}};
    static boolean[][] visit;

    public static void main (String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X

        area = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void process() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(area[i][j] == 1 && !visit[i][j]) {
                    DFS(j,i);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int x, int y) {
        visit[y][x] = true;

        for(int k=0; k<8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(visit[ny][nx]) continue;
            if(area[ny][nx] != 1) continue;

            DFS(nx, ny);
        }
    }
}