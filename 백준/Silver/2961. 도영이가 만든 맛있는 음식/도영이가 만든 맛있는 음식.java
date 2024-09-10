import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] gredients;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        gredients = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gredients[i][0] = Integer.parseInt(st.nextToken());
            gredients[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        long[] V = { 1L, 0L };
        DFS(0, V);
        System.out.println(MIN);
    }

    static void DFS(int K, long[] V) {
        if (K == N) {
            if (V[0] != 1L && V[1] != 0L)
                MIN = Math.min(MIN, (int) Math.abs(V[0] - V[1]));
            return;
        }

        DFS(K + 1, new long[] { V[0] * gredients[K][0], V[1] + gredients[K][1] });
        DFS(K + 1, new long[] { V[0], V[1] });
    }
}