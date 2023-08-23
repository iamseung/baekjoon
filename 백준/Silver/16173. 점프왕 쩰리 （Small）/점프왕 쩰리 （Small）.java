import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] area;
    static int[][] dir = {{0,1},{1,0}};
    static boolean[][] visit;
    static boolean can;

    public static void main (String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine()); // Y

        area = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void process() {
        DFS(0,0);
        System.out.println((can) ? "HaruHaru" : "Hing");
    }

    public static void DFS(int x, int y) {
        if(x == N-1 && y == N-1) {
            can = true;
            return;
        }

        visit[y][x] = true;

        for(int k=0; k<2; k++) {
            int nx = x + dir[k][0] * area[y][x];
            int ny = y + dir[k][1] * area[y][x];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(visit[ny][nx]) continue;

            DFS(nx, ny);

            visit[ny][nx] = false;
        }
    }
}