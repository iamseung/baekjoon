import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, H;
    static boolean[][] adj;
    static int MIN = 4;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로선의 개수
        M = Integer.parseInt(st.nextToken()); // 가로선의 개수
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치의 개수

        adj = new boolean[H + 1][N + 2];

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 우측과 연결되어 있음
            adj[a][b] = true;
        }
    }

    static void process() {
        if (M == 0) {
            System.out.println(0);
            return;
        }

        DFS(0, 1);

        System.out.println(MIN == 4 ? -1 : MIN);
    }

    static void DFS(int depth, int Y) {
        if (depth >= MIN) {
            return;
        }

        if (isAllConnected()) {
            MIN = Math.min(MIN, depth);
            return;
        }

        // 세로
        for (int i = Y; i <= H; i++) {
            // 가로
            for (int j = 1; j <= N; j++) {
                if (!adj[i][j] && !adj[i][j - 1] && !adj[i][j + 1]) {
                    adj[i][j] = true;
                    DFS(depth + 1, i);
                    adj[i][j] = false;
                }
            }
        }
    }

    // 모든 사다리가 연결됐는지 탐색
    static boolean isAllConnected() {
        // 가로, N
        for (int i = 1; i <= N; i++) {
            int y = 1, x = i;

            while (y <= H) {
                if (adj[y][x]) {
                    x += 1;
                } else if (x - 1 >= 0 && adj[y][x - 1]) {
                    x -= 1;
                }

                y++;
            }

            if (x != i)
                return false;
        }

        return true;
    }
}