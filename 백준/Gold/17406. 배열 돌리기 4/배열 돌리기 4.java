import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[][] arr;
    static int[][] cycle;
    static int[] orders;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X
        K = Integer.parseInt(st.nextToken()); // 연산의 수

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 가장 왼쪽 윗칸이 r-s, c-s & 가장 오른쪽 아랫칸이 r+s, c+s
            cycle[i][0] = Integer.parseInt(st.nextToken()) - 1; // r
            cycle[i][1] = Integer.parseInt(st.nextToken()) - 1; // c
            cycle[i][2] = Integer.parseInt(st.nextToken()); // s
        }
    }

    static void process() {
        // 회전 순서를 기록한 배열
        orders = new int[K];
        visited = new boolean[K];
        backTracking(0);
        System.out.println(MIN);
    }

    static void backTracking(int depth) {
        if (depth == K) {
            doCycle();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            orders[depth] = i;
            backTracking(depth + 1);
            visited[i] = false;
        }
    }

    static void doCycle() {
        int[][] tmp = copyArr();

        for (int k = 0; k < K; k++) {
            int r = cycle[orders[k]][0];
            int c = cycle[orders[k]][1];
            int S = cycle[orders[k]][2];

            for (int s = 1; s <= S; s++) {
                // 위
                // 맨위, 오른쪽 값
                int upTmp = tmp[r - s][c + s];
                for (int y = c + s; y > c - s; y--)
                    tmp[r - s][y] = tmp[r - s][y - 1];

                // 오른쪽
                // 맨아래, 오른쪽 값
                int rightTmp = tmp[r + s][c + s];
                for (int x = r + s; x > r - s; x--)
                    tmp[x][c + s] = tmp[x - 1][c + s];

                tmp[r - s + 1][c + s] = upTmp;
                // 아래
                // 만아래, 왼쪽값
                int leftTmp = tmp[r + s][c - s];
                for (int y = c - s; y < c + s; y++)
                    tmp[r + s][y] = tmp[r + s][y + 1];

                tmp[r + s][c + s - 1] = rightTmp;
                // 왼쪽
                for (int x = r - s; x < r + s; x++)
                    tmp[x][c - s] = tmp[x + 1][c - s];

                tmp[r + s - 1][c - s] = leftTmp;
            }
        }

        MIN = Math.min(MIN, findMinValue(tmp));
    }

    static int[][] copyArr() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                temp[i][j] = arr[i][j];

        return temp;
    }

    static int findMinValue(int[][] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, Arrays.stream(array[i]).sum());
        }

        return min;
    }
}