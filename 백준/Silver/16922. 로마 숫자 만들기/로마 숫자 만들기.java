import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num = { 1, 5, 10, 50 };
    static Set<Integer> set = new HashSet<>();
    static int N;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        bruteForce(0, 0, 0);
        System.out.println(set.size());
    }

    static void bruteForce(int depth, int sum, int idx) {
        if (depth == N) {
            set.add(sum);
            return;
        }

        for (int i = idx; i < num.length; i++) {
            bruteForce(depth + 1, sum + num[i], i);
        }
    }
}