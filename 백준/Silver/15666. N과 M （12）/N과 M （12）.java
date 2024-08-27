import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N 개 중에 M 개 선택
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        Arrays.sort(arr);
        backTracking(0, 0);
        System.out.println(sb.toString());
    }

    static void backTracking(int depth, int start) {
        if (depth == M) {
            for (int s : selected) {
                sb.append(s + " ");
            }
            sb.append("\n");
            return;
        }

        for (int cur = start; cur < N; cur++) {
            // 중복 제거를 위한 조건
            if (cur > start && arr[cur] == arr[cur - 1])
                continue;

            selected[depth] = arr[cur];
            backTracking(depth + 1, cur);
        }
    }
}