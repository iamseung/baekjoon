import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static double[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new double[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Double.parseDouble(br.readLine());
    }

    public static void process() {
        double[] dp = new double[N + 1];
        double max = 0;

        for (int i = 1; i <= N; i++) {
            // 이전까지의 곱 x 현재 값, 현재 값 비교
            dp[i] = Math.max(dp[i - 1] * arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("%.3f", max));
    }
}