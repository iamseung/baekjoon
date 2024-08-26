import java.io.*;
import java.util.*;
import java.util.stream.*;

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
        N = Integer.parseInt(st.nextToken()); // N 개의 자연수 중에
        M = Integer.parseInt(st.nextToken()); // M 개 선택

        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        Arrays.sort(arr);
        backTracking(0);
        System.out.println(sb.toString());
    }

    static void backTracking(int k) {
        if (k == M) {
            for (int s : selected) {
                sb.append(s + " ");
            }
            sb.append("\n");
            return;
        }

        for (int cur = 0; cur < N; cur++) {
            int last = (k == 0) ? 0 : k - 1;

            if (selected[last] <= arr[cur]) {
                selected[k] = arr[cur];
                backTracking(k + 1);
                selected[k] = 0;
            }
        }
    }
}