import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, result = 0;
    static int[] snow;

    public static void main(String[] args) throws Exception {
        input();
        DFS(1, 0, 0);
        System.out.println(result);
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        snow = new int[N + 1];
        snow[0] = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void DFS(int size, int time, int idx) {
        if (time > M) {
            return;
        }

        result = Math.max(result, size);

        if (idx <= N - 1) {
            DFS(size + snow[idx + 1], time + 1, idx + 1);
        }

        if (idx <= N - 2) {
            DFS((size / 2) + snow[idx + 2], time + 1, idx + 2);
        }
    }
}