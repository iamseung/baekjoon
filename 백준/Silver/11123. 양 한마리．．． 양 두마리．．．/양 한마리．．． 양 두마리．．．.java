import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void process() {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == '#' && !visit[i][j]) {
                    DFS(j,i);
                    cnt++;
                }
            }
        }

        sb.append(cnt+"\n");
    }

    public static void DFS(int x, int y) {
        visit[y][x] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0||ny<0||nx>=M||ny>=N) continue;
            if(visit[ny][nx]) continue;
            if(map[ny][nx] != '#') continue;

            DFS(nx, ny);
        }
    }
}