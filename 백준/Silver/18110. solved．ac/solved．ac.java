import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
    }

    static void process() {
        Arrays.sort(arr);
        int gap = (int) Math.round(N * 0.15);

        double S = IntStream.range(gap, N - gap)
                .map(a -> arr[a])
                .sum();

        System.out.println(Math.round((double) S / (N - gap * 2)));
    }
}