import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M,ans=0;
    static char[][] map;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[] alpha = new boolean[26];
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void pro() throws IOException {
        dfs(0,0,1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int count) {
        alpha[map[y][x]-'A'] = true;
        ans = Math.max(ans, count);
        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0|| nx>=M || ny>=N) continue;
            if(alpha[map[ny][nx]-'A']) continue;

            dfs(nx, ny, count+1);

            alpha[map[ny][nx]-'A'] = false;
        }
    }
}