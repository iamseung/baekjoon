import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] numbers;
    static boolean[] visited;
    static Set<String> comb = new HashSet<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }

    static void process() {
        visited = new boolean[N];
        backTracking(0, "");
        System.out.println(comb.size());
    }

    static void backTracking(int depth, String str) {
        if (depth == K) {
            comb.add(str);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            backTracking(depth + 1, str + numbers[i]);
            visited[i] = false;
        }
    }
}