import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] area;
    static boolean[][] visit;
    static int N, M, K, max, trash;

    static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        visit = new boolean[N][M];

        while (K-- > 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            area[Integer.parseInt(st1.nextToken()) - 1][Integer.parseInt(st1.nextToken()) - 1] = 1;
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 1 && !visit[i][j]) {
                    trash = 0;
                    dfs(j, i);
                    max = Math.max(max, trash);
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y) {
        trash++;
        visit[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || ny >= N || nx >= M)
                continue;
            if (visit[ny][nx])
                continue;
            if (area[ny][nx] != 1)
                continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}