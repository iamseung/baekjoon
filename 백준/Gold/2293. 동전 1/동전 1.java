import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());
    }

    /*
     * 12345678910
     * 2345678910
     * 5678910
     */
    static void process() {
        Arrays.sort(coins);
        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[K]);
    }
}