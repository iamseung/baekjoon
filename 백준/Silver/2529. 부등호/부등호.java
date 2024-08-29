import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] arr;
    static int[] selected;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine()); // 2
        arr = new String[N]; // < >
        selected = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = st.nextToken();
    }

    static void process() {
        backTracking(0);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void backTracking(int K) {
        if (K == N + 1) {
            String str = "";
            for (int s : selected)
                str += String.valueOf(s);

            list.add(str);
            return;
        }

        for (int cur = 0; cur <= 9; cur++) {
            if (K > 0) {
                if (arr[K - 1].equals(">") && selected[K - 1] < cur) {
                    continue;
                }

                if (arr[K - 1].equals("<") && selected[K - 1] > cur) {
                    continue;
                }
            }

            boolean isUsed = false;

            for (int i = 0; i < K; i++) {
                if (selected[i] == cur) {
                    isUsed = true;
                    break;
                }
            }

            if (!isUsed) {
                selected[K] = cur;
                backTracking(K + 1);
            }
        }
    }
}