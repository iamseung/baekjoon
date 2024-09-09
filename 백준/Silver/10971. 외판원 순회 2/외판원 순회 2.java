import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long MIN = Integer.MAX_VALUE;
    static int[][] W;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            DFS(i, i, 0);
        }

        System.out.println(MIN);
    }

    // 시작 좌표, 현재 좌표, 비용
    static void DFS(int start, int now, long cost) {
        if (allVisited()) {
            // 모든 곳을 방문했고, 시작 점으로 돌아갈 수 있을 경우 갱신
            if (W[now][start] != 0) {
                MIN = Math.min(MIN, cost + W[now][0]);
            }

            return;
        }

        for (int i = 1; i < N; i++) {
            // 해당 도시를 방문하지 않았으며 루트가 존재
            if (!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                DFS(start, i, cost + W[now][i]);
                visited[i] = false;
            }
        }
    }

    public static boolean allVisited() {
        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }
}