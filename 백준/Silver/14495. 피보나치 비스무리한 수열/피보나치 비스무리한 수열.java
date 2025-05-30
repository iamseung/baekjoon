import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String args[]) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process() {
        long[] dp = new long[N + 1];

        if (N < 4) {
            dp = new long[4];
        }

        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }

        System.out.println(dp[N]);
    }
}