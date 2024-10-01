import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] arr;
    static int cnt = 0;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        used = new boolean[N];
        backTracking(0, 500);
        System.out.println(cnt);
    }

    static void backTracking(int depth, int v) {
        if (depth == N) {
            cnt++;
            return;
        }

        if (v < 500)
            return;

        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;

            used[i] = true;
            backTracking(depth + 1, v + arr[i] - K);
            used[i] = false;
        }

    }
}