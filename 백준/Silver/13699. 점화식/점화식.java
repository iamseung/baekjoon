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
        long[] dp = new long[36];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}