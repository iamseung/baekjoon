import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int count = 0;
    static int[] arr = { 0, 1, 2 };

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        backTracking(0, 0);
        System.out.println(count);
    }

    static void backTracking(int depth, int v) {
        if (depth == N) {
            if (String.valueOf(v).length() == N && v != 0 && v % 3 == 0)
                count++;

            return;
        }

        for (int i = 0; i < arr.length; i++)
            backTracking(depth + 1, v * 10 + arr[i]);
    }
}