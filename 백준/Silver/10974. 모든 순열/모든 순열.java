import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        selected = new int[N];
        backTracking(0);
        System.out.println(sb.toString());
    }

    static void backTracking(int k) {
        if (k == N) {
            for (int s : selected)
                sb.append((s + 1) + " ");

            sb.append("\n");
            return;
        }

        for (int cur = 0; cur < N; cur++) {
            boolean isUsed = false;

            for (int t = 0; t < k; t++) {
                if (selected[t] == cur) {
                    isUsed = true;
                    break;
                }
            }

            if (!isUsed) {
                selected[k] = cur;
                backTracking(k + 1);
                selected[k] = 0;
            }
        }
    }
}