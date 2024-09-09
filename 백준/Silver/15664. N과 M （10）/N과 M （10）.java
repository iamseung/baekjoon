import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, selected;

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
        Arrays.sort(arr);
        selected = new int[M];
        DFS(0, 0);
        System.out.println(sb.toString());
    }

    // K, index
    static void DFS(int depth, int start) {
        if (depth == M) {
            for (int s : selected)
                sb.append(s + " ");

            sb.append("\n");
            return;
        }

        int lastUsed = -1; // 이전에 사용한 숫자를 저장
        for (int cur = start; cur < N; cur++) {
            if (arr[cur] == lastUsed)
                continue; // 이전에 사용한 숫자와 같다면 건너뛰기

            selected[depth] = arr[cur];
            DFS(depth + 1, cur + 1);
            lastUsed = arr[cur]; // 이번에 사용한 숫자를 저장
        }
    }
}