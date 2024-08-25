import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        selected = new int[M];
        Arrays.sort(arr);
        backTracking(0);

        System.out.println(sb.toString());
    }

    static void backTracking(int k) {
        if (k == M) {
            String str = "";
            for (int s : selected)
                str += s + " ";
            sb.append(str + "\n");
            return;
        }

        for (int cand = 0; cand < N; cand++) {
            boolean isUsed = false;

            for (int i = 0; i < k; i++) {
                if (arr[cand] == selected[i]) {
                    isUsed = true;
                    continue;
                }
            }

            if (!isUsed) {
                selected[k] = arr[cand];
                backTracking(k + 1);
                selected[k] = 0;
            }
        }
    }
}